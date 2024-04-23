package com.example.WatchProject.Controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.type.filter.AbstractClassTestingTypeFilter;
import org.springframework.data.domain.Page;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.WatchProject.Entity.AccountEntity;
import com.example.WatchProject.Entity.CartEntity;
import com.example.WatchProject.Entity.CustomUserDetails;
import com.example.WatchProject.Entity.OrderDetailEntity;
import com.example.WatchProject.Entity.OrderEntity;
import com.example.WatchProject.Entity.PermissionEntity;
import com.example.WatchProject.Entity.ProductEntity;
import com.example.WatchProject.Entity.ProductTypeEntity;
import com.example.WatchProject.Repository.AccountRepository;
import com.example.WatchProject.Repository.UserRepository;
import com.example.WatchProject.Service.ICartService;
import com.example.WatchProject.Service.IOrderDetailService;
import com.example.WatchProject.Service.IOrderService;
import com.example.WatchProject.Service.IProductService;
import com.example.WatchProject.Service.IProductTypeService;
import com.example.WatchProject.Service.iml.AccountService;
import com.example.WatchProject.Service.iml.PermissionService;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/")
public class ClientController {
	@Autowired
	private IProductService productService;
	@Autowired
	private IProductTypeService productTypeService;
	@Autowired
	private AccountRepository userRepository;
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private ICartService cartService;
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IOrderDetailService detailService;
	@Autowired
	private UserRepository repository;

	@GetMapping({ "home", "", "*" })
	public String goHome(Model model) {
		List<ProductEntity> listProduct = this.productService.getAll();
		model.addAttribute("listProduct", listProduct);
		return "index";
	}

	@GetMapping("shop")
	public String Shop(Model model, @RequestParam(name = "page", defaultValue = "1") int pageNo,
			@RequestParam(name = "type", defaultValue = "1") int type) {
		ProductTypeEntity typeproduct = productTypeService.findByName(type);
		Page<ProductEntity> listProduct = productService.getAllbyType(pageNo, typeproduct);
		model.addAttribute("type", type);
		model.addAttribute("totalPage", listProduct.getTotalPages());
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("listProduct", listProduct);
		return "shop";
	}

	@GetMapping("about")
	public String About(Model model) {
		return "about";
	}

	@GetMapping("admin")
	public String Admin(Model model) {
		return "redirect:/admin/";
	}

	@GetMapping("cart")
	public String Cart(Model model, @RequestParam(name = "delete", defaultValue = "0") int id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		AccountEntity accountEntity = accountService.findByUsername(username);
		if (accountEntity == null) {
			return "redirect:/login";
		}
		CartEntity cartEntity = this.cartService.findProductFromCart(id, accountEntity.getAccount_id());
		if (id == 0) {
			List<CartEntity> cartEntities = this.cartService.listCart(accountEntity.getAccount_id());
			int totalCart = this.cartService.totalCart(accountEntity.getAccount_id());
			model.addAttribute("totalCart", totalCart);
			model.addAttribute("Listcart", cartEntities);
			return "cart";
		}
		if (cartEntity != null) {
			this.cartService.delOneProductCart(accountEntity.getAccount_id(), id);
			List<CartEntity> cartEntities = this.cartService.listCart(accountEntity.getAccount_id());
			int totalCart = this.cartService.totalCart(accountEntity.getAccount_id());
			model.addAttribute("totalCart", totalCart);
			model.addAttribute("Listcart", cartEntities);
			return "cart";
		}
		return "cart";
	}

	@GetMapping("checkout")
	public String Checkout(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		AccountEntity accountEntity = accountService.findByUsername(username);
		if (accountEntity == null) {
			return "redirect:/login";
		}
		List<CartEntity> cartEntities = this.cartService.listCart(accountEntity.getAccount_id());
		if(cartEntities.isEmpty()) {
			return "redirect:/shop";
		}
		int totalCart = this.cartService.totalCart(accountEntity.getAccount_id());
		OrderEntity order = new OrderEntity();
		LocalDate localDate = LocalDate.now();
		model.addAttribute("accountid", accountEntity.getAccount_id());
		model.addAttribute("totalCart", totalCart);
		model.addAttribute("Listcart", cartEntities);
		model.addAttribute("order", order);
		model.addAttribute("date", localDate);
		return "checkout";
	}

	@GetMapping("contact")
	public String Contact(Model model) {
		return "contact";
	}

	@GetMapping("/login")
	public String Login(Authentication authentication, Model model) {
		if (authentication != null && authentication.isAuthenticated()) {
			model.addAttribute("IsLogged", true);
			return ("redirect:/");
		} else {
			model.addAttribute("IsLogged", false);
			return "login";
		}

	}

	@GetMapping("confirmation")
	public String Confirmation(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		AccountEntity accountEntity = accountService.findByUsername(username);
		this.cartService.delProductCart(accountEntity.getAccount_id());
		OrderEntity orderEntity = this.orderService.getOneById(accountEntity.getAccount_id());
		List<OrderDetailEntity> detailEntities = this.detailService.getByOrderId(orderEntity.getOrder_id());
		model.addAttribute("details", detailEntities);
		model.addAttribute("account", accountEntity);
		model.addAttribute("order", orderEntity);
		return "confirmation";
	}

	@PostMapping("confirmation")
	public String Order(Model model, @ModelAttribute("order") OrderEntity order) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		AccountEntity accountEntity = accountService.findByUsername(username);
		order.setCustomer_id(accountEntity);
		if (this.orderService.AddtoOrder(order)) {
			List<CartEntity> cartEntities = this.cartService.listCart(order.getCustomer_id().getAccount_id());
			List<OrderDetailEntity> details = new ArrayList<>();
			cartEntities.forEach(product -> {
				details.add(new OrderDetailEntity(null, order, product.getProduct(), product.getProduct_quantity()));
				ProductEntity productEntity = this.productService.findByID(product.getProduct().getProduct_id());
				this.productService.updateInventoryProduct(
						productEntity.getProduct_inventory() - product.getProduct_quantity(),
						product.getProduct().getProduct_id());
			});
			details.forEach(product -> {
				this.detailService.AddtoOrderDetail(product);
			});
			return "redirect:/confirmation";
		}
		return "shop";
	}

	@GetMapping("product_details/{id}")
	public String ProductDetails(Model model, @PathVariable("id") int id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		AccountEntity accountEntity = accountService.findByUsername(username);
		ProductEntity product = this.productService.findByID(id);
		model.addAttribute("productDetail", product);
		CartEntity cartEntity = new CartEntity();
		model.addAttribute("accountid", accountEntity.getAccount_id());
		model.addAttribute("cart", cartEntity);
		return "product_details";
	}

	@PostMapping("shop")
	public String addProductToCart(@ModelAttribute("cart") CartEntity cart, RedirectAttributes redirectAttributes) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		AccountEntity accountEntity = accountService.findByUsername(username);
		CartEntity cartEntity = this.cartService.findProductFromCart(cart.getProduct().getProduct_id(),
				accountEntity.getAccount_id());
		ProductEntity productEntity = this.productService.findByID(cart.getProduct().getProduct_id());
		if (cartEntity == null) {
			if (productEntity.getProduct_inventory() >= cart.getProduct_quantity() ) {
				if (this.cartService.addProductToCart(cart)) {
					redirectAttributes.addFlashAttribute("Success", "Thêm thành công");
					return "redirect:/shop";
				} else {
					return "redirect:/product_details/" + cart.getProduct().getProduct_id();
				}
			} else {
				redirectAttributes.addFlashAttribute("Error",
						"Không đủ số lượng sản phẩm trong kho ( Trong kho chỉ còn "
								+ productEntity.getProduct_inventory() + " sản phẩm");
				return "redirect:/product_details/" + cart.getProduct().getProduct_id();
			}
		} else {
			this.cartService.updateProductCart(cart.getProduct_quantity() + cartEntity.getProduct_quantity(),
					cart.getProduct().getProduct_id());
			redirectAttributes.addFlashAttribute("Success", "Thêm thành công");
			return "redirect:/shop";
		}
	}

//	@GetMapping("*")
//	public String Homepage(Model model) {
//		List<ProductEntity> listProduct = this.productService.getAll();
//		model.addAttribute("listProduct", listProduct);
//		model.addAttribute("user", new AccountEntity());
//		
//		return "index";
//	}

	@GetMapping("register")
	public String Register(Model model) {
		model.addAttribute("user", new AccountEntity());
		return "register";
	}

	@PostMapping("process_register")
	public String processRegister(AccountEntity user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encoderPasswrod = encoder.encode(user.getPassword());
		user.setPassword(encoderPasswrod);
		PermissionEntity permissionEntity = permissionService.findById(3);
		user.setPermission(permissionEntity);
		userRepository.save(user);
		return "redirect:login";
	}

	@GetMapping("information")
	public String information_index(Model model, Authentication authentication) {

		if (authentication != null && authentication.isAuthenticated()) {
			authentication = SecurityContextHolder.getContext().getAuthentication();
			CustomUserDetails accountEntity = ((CustomUserDetails) authentication.getPrincipal());
			String name = ((CustomUserDetails) accountEntity).getAccountEntity().getCustomer_name().toString();
			String address = ((CustomUserDetails) accountEntity).getAccountEntity().getCustomer_address().toString();
			String phone = ((CustomUserDetails) accountEntity).getAccountEntity().getCustomer_phone().toString();
			String email = ((CustomUserDetails) accountEntity).getAccountEntity().getCustomer_email().toString();
			String username = ((CustomUserDetails) accountEntity).getAccountEntity().getUsername().toString();
			AccountEntity entity = accountService.findByUsername(username);
			model.addAttribute("user", entity);
			model.addAttribute("name", name);
			model.addAttribute("address", address);
			model.addAttribute("phone", phone);
			model.addAttribute("email", email);

			return "information";
		}
		return "login";

	}

	@PostMapping("process_infor")
	public String process_infor(@ModelAttribute("user") AccountEntity user) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CustomUserDetails accountEntity = ((CustomUserDetails) authentication.getPrincipal());
		int id = ((CustomUserDetails) accountEntity).getAccountEntity().getAccount_id();
		accountService.update(user.getCustomer_name(), user.getCustomer_email(), user.getCustomer_address(),
				user.getCustomer_phone(), id);
		return "redirect:information";
	}

	@GetMapping("orderlist")
	public String orderlist_index(Model model, Authentication authentication) {
		if (authentication != null && authentication.isAuthenticated()) {
			authentication = SecurityContextHolder.getContext().getAuthentication();
			CustomUserDetails accountEntity = ((CustomUserDetails) authentication.getPrincipal());
			int id_user = accountEntity.getAccountEntity().getAccount_id();
			List<OrderEntity> order_entity = orderService.getAllByAccountId(id_user);
			model.addAttribute("order", order_entity);
			return "orderlist";
		}
		return "login";
	}
	@GetMapping("orderlistdetail/{id}")
	public String detail_orderlist(Model model, Authentication authentication,@PathVariable("id")OrderEntity id_order) {
		
		if (authentication != null && authentication.isAuthenticated()) {
			authentication = SecurityContextHolder.getContext().getAuthentication();
			CustomUserDetails accountEntity = ((CustomUserDetails) authentication.getPrincipal());
			OrderDetailEntity detailEntities = this.detailService.getOneByOrderID(id_order.getOrder_id());
			List<OrderDetailEntity >listDetail=  detailService.getByOrderId(id_order.getOrder_id());
			String username= accountEntity.getAccountEntity().getUsername().toString();
			AccountEntity entity=accountService.findByUsername(username);
			model.addAttribute("account", entity);
			model.addAttribute("orderdetail", detailEntities);
			model.addAttribute("list", listDetail);
			return "orderlistdetail";
		}
		return "login";
		
	}
//	@GetMapping("invalidSession")
//	public String invalidsession() {
//		return "invalidsession";
//	}
//
//	@GetMapping("expiredSession")
//	public String expiredsession() {
//		return "expiredsession";
//	}
}