package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.NodeList;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class CartController {
	@GetMapping("/cart")
	public String cartController(Model model) {
		return "cart";
	}
	@PostMapping("/add_cart")
	public String add_to_cart(Model model) {
		//TODO: process POST request
		
		return "add_cart";
	}
	
	
}
