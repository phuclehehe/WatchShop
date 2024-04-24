package com.example.WatchShop1.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.WatchShop1.Service.iml.AccountService;
@Controller
@RequestMapping("/home/pagecontrol")
public class HomeController {
	private AccountService accountService;
	
//	@Autowired
//	public AccountController(AccountServiceImpl accountService) {
//		this.accountService = accountService;
//	}
	
	@GetMapping
	public String getPage(@RequestParam("page") String page, Model model) {
	    if ("home".equals(page)) {
//	        List<Account> accountList = accountService.getAllAccounts();
//	        model.addAttribute("accounts", accountList);
	        model.addAttribute("page","home");
	        return "/admin/doc/index_admin";  // Return the name of the view to be displayed
	    } else {
	        // Xử lý các trang khác tại đây (nếu có)
	        return "error"; // Ví dụ: Trả về một trang lỗi nếu page không hợp lệ
	    }
	}
}
