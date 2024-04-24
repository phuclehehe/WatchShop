//package com.example.demo.Controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.example.demo.Service.AccountService;
//
//@Controller
//public class LoginController {
//
//	@Autowired
//	private AccountService accountService;
//
//	@PostMapping("/login")
//	public String login(@RequestParam("username") String username, @RequestParam("current-password") String password,
//			Model model) {
//		if (accountService.authenticate(username, password) == true) {
//			return "/admin/doc/index_admin";
//		} else {
//
//			model.addAttribute("error", "Tên người dùng hoặc mật khẩu không đúng");
//			return "/admin/doc/dangnhap";
//		}
//	}
//}
