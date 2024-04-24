package com.example.WatchShop1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.WatchShop1.Entity.AccountEntity;
import com.example.WatchShop1.Service.iml.AccountService;

@Controller
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@GetMapping("/account/pagecontrol")
	public String getPage(@RequestParam("page") String page, Model model) {
	    if ("QLTK".equals(page)) {
	        List<AccountEntity> accountList = accountService.findAccounts();
	        model.addAttribute("accounts", accountList);
	        model.addAttribute("page","QLTK");
	        return "/admin/doc/index_admin";  // Return the name of the view to be displayed
	    } else {
	        // Xử lý các trang khác tại đây (nếu có)
	        return "error"; // Ví dụ: Trả về một trang lỗi nếu page không hợp lệ
	    }
	}
	@GetMapping("/add_account/pagecontrol")
	public String getAddPage(@RequestParam("page") String page, Model model) {
	    if ("Add_Account".equals(page)) {
//	        List<Account> accountList = accountService.getAllAccounts();
//	        model.addAttribute("accounts", accountList);
	        model.addAttribute("page","Add_Account");
	        return "/admin/doc/index_admin";  // Return the name of the view to be displayed
	    } else {
	        // Xử lý các trang khác tại đây (nếu có)
	        return "error"; // Ví dụ: Trả về một trang lỗi nếu page không hợp lệ
	    }
	}
	@GetMapping("/admin/qltaikhoan/delete/{id}")
	 public String deleteTaikhoan(@PathVariable("id") Integer id , RedirectAttributes redirectAttributes) {
		accountService.deleteTaikhoan(id);
		redirectAttributes.addAttribute("deleteSuccess", true);
       return "redirect:/account/pagecontrol?page=QLTK";
   }
}
