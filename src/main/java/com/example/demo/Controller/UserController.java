package com.example.demo.Controller;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.CustomUserDetail;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.CookiesService;


@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;

	private CustomUserDetail userDetail;
	@Autowired
	private CookiesService cookiesService;
	@GetMapping("/*")
	public String Homepage(Model model) {
		model.addAttribute("user",new User());	
		return "index";
	}
	@GetMapping("/login")
	public String Login(Model model) {

			return "login";
	}
//	@GetMapping("/login")
//	public String processLogin(@RequestParam("username")String username,@RequestParam("password")String password,@RequestParam(name="remember",required = false)String remember,Model model) {
//		User user1= userRepository.findByUsername(username);
//		System.out.println(user1.getUsername());
//		System.out.println(username);
//		if(username== user1.getUsername()) {
//			if(remember != null) {
//				cookiesService.addCookie( "username", username, 1);
//				cookiesService.addCookie( "password", password, 1);
//				model.addAttribute("username",cookiesService.getCookie( "username"));
//				model.addAttribute("password",cookiesService.getCookie( "password"));
//			}
//			else {
//				cookiesService.removeCookie( "username");
//				cookiesService.removeCookie( "password");
//			}
//		}
//		return "login";
//	}
	@GetMapping("/register")
	public String Register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	@PostMapping("/process_register")
	public String processRegister(User user) {
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		String encoderPasswrod= encoder.encode(user.getPassword());
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
