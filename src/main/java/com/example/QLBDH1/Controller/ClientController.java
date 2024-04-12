package com.example.QLBDH1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.QLBDH1.Entity.CartEntity;
import com.example.QLBDH1.Entity.ProductEntity;
import com.example.QLBDH1.Entity.ProductTypeEntity;
import com.example.QLBDH1.Service.ICartService;
import com.example.QLBDH1.Service.IProductService;
import com.example.QLBDH1.Service.IProductTypeService;

@Controller
@RequestMapping("")
public class ClientController {
	@Autowired
	private IProductService productService;
	@Autowired
	private IProductTypeService productTypeService;
	
	@Autowired
	private ICartService cartService;
	@GetMapping("/home")
	public String Home(Model model) {
		return "index";
	}

	@GetMapping("/shop")
	public String Shop(Model model,@RequestParam(name= "page", defaultValue = "1") int pageNo,@RequestParam(name="type", defaultValue = "1") int type) {
		ProductTypeEntity typeproduct= productTypeService.findByName(type);
		Page<ProductEntity> listProduct=productService.getAllbyType(pageNo, typeproduct);
		model.addAttribute("type", type);
		model.addAttribute("totalPage", listProduct.getTotalPages());
		model.addAttribute("currentPage",pageNo);
		model.addAttribute("listProduct", listProduct);
		return "shop";
	}

	@GetMapping("/about")
	public String About(Model model) {
		return "about";
	}

	@GetMapping("/cart")
	public String Cart(Model model,@RequestParam(name= "id") int account_id) {
		List<CartEntity> cartEntities=this.cartService.listCart(account_id);
		int totalCart=this.cartService.totalCart(account_id);
		model.addAttribute("totalCart",totalCart);
		model.addAttribute("Listcart", cartEntities);
		return "cart";
	}
	
	@GetMapping("/checkout")
	public String Checkout(Model model,@RequestParam(name= "id") int account_id) {
		List<CartEntity> cartEntities=this.cartService.listCart(account_id);
		int totalCart=this.cartService.totalCart(account_id);
		model.addAttribute("totalCart",totalCart);
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
		return "confirmation";
	}
	
	@GetMapping("/product_details/{id}")
	public String ProductDetails(Model model, @PathVariable("id") int id) {
		ProductEntity product= this.productService.findByID(id);
		model.addAttribute("productDetail", product);
		CartEntity cartEntity= new CartEntity();
		model.addAttribute("cart", cartEntity);
		return "product_details";
	}
	
	@PostMapping("/shop")
	public String addProductToCart(@ModelAttribute("cart") CartEntity cart,RedirectAttributes redirectAttributes) {
		if(this.cartService.addProductToCart(cart)) {
			redirectAttributes.addFlashAttribute("Success", "Thêm thành công");
			return "redirect:/shop";
		}
		return "redirect:/product_details/"+cart.getProduct_id();
	}
}