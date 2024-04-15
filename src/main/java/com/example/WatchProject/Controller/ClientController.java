package com.example.WatchProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import com.example.WatchProject.Entity.PermissionEntity;
import com.example.WatchProject.Entity.ProductEntity;
import com.example.WatchProject.Entity.ProductTypeEntity;
import com.example.WatchProject.Repository.AccountRepository;
import com.example.WatchProject.Service.ICartService;
import com.example.WatchProject.Service.IProductService;
import com.example.WatchProject.Service.IProductTypeService;

@Controller
@RequestMapping("")
public class ClientController {
	@Autowired
	private IProductService productService;
	@Autowired
	private IProductTypeService productTypeService;
	@Autowired
	private AccountRepository userRepository;

	@Autowired
	private ICartService cartService;

	@GetMapping("/home")
	public String goHome(Model model) {
		List<ProductEntity> listProduct = this.productService.getAll();
		model.addAttribute("listProduct", listProduct);
		return "index";
	}

	@GetMapping("/")
	public String Home(Model model) {
		List<ProductEntity> listProduct = this.productService.getAll();
		model.addAttribute("listProduct", listProduct);
		return "index";
	}

	@GetMapping("/shop")
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

	@GetMapping("/about")
	public String About(Model model) {
		return "about";
	}

	@GetMapping("/admin")
	public String Admin(Model model) {
		return "redirect:/admin/";
	}

	@GetMapping("/cart")
	public String Cart(Model model, @RequestParam(name = "id") int account_id) {
		List<CartEntity> cartEntities = this.cartService.listCart(account_id);
		int totalCart = this.cartService.totalCart(account_id);
		model.addAttribute("totalCart", totalCart);
		model.addAttribute("Listcart", cartEntities);
		return "cart";
	}

	@GetMapping("/checkout")
	public String Checkout(Model model, @RequestParam(name = "id") int account_id) {
		List<CartEntity> cartEntities = this.cartService.listCart(account_id);
		int totalCart = this.cartService.totalCart(account_id);
		model.addAttribute("totalCart", totalCart);
		model.addAttribute("Listcart", cartEntities);
		return "checkout";
	}

	@GetMapping("/contact")
	public String Contact(Model model) {
		return "contact";
	}

	@GetMapping("/login")
	public String Login(Model model) {
		return "login";
	}

	@GetMapping("/confirmation")
	public String Confirmation(Model model) {
//		List<CartEntity> cartEntities = this.cartService.listCart(account_id);
//		int totalCart = this.cartService.totalCart(account_id);
//		model.addAttribute("totalCart", totalCart);
//		model.addAttribute("Listcart", cartEntities);
		return "confirmation";
	}

	@GetMapping("/product_details/{id}")
	public String ProductDetails(Model model, @PathVariable("id") int id) {
		ProductEntity product = this.productService.findByID(id);
		model.addAttribute("productDetail", product);
		CartEntity cartEntity = new CartEntity();
		model.addAttribute("cart", cartEntity);
		return "product_details";
	}

	@PostMapping("/shop")
	public String addProductToCart(@ModelAttribute("cart") CartEntity cart, RedirectAttributes redirectAttributes) {
		if (this.cartService.addProductToCart(cart)) {
			redirectAttributes.addFlashAttribute("Success", "Thêm thành công");
			return "redirect:/shop";
		}
		return "redirect:/product_details/" + cart.getProduct().getProduct_id();
	}

	@GetMapping("/*")
	public String Homepage(Model model) {
		model.addAttribute("user", new AccountEntity());
		return "index";
	}

	@GetMapping("/register")
	public String Register(Model model) {
		model.addAttribute("user", new AccountEntity());
		return "register";
	}

	@PostMapping("/process_register")
	public String processRegister(AccountEntity user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encoderPasswrod = encoder.encode(user.getPassword());
		user.setPassword(encoderPasswrod);
		userRepository.save(user);
		return "redirect:login";
	}

	@GetMapping("/invalidSession")
	public String invalidsession() {
		return "invalidsession";
	}

	@GetMapping("/expiredSession")
	public String expiredsession() {
		return "expiredsession";
	}
}