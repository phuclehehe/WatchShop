package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.query.EqlParser.New_valueContext;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Repository.UserRepository;

@Controller

public class UserController {
	@Autowired
	private UserRepository userRepository;
	@GetMapping("/")
	public String Homepage() {
		
		return"index";
	}
	@GetMapping("/login")
	public String Login() {
		return "login";
	}
	@GetMapping("/nv")
	public String nv_index() {
		return "nv";
	}

}
