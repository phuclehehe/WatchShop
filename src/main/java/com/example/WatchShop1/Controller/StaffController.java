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
public class StaffController {
	@Autowired
	private AccountService accountService;
	
	public StaffController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@GetMapping("/staff/pagecontrol")
	public String getPage(@RequestParam("page") String page, Model model) {
	    if ("QLNV".equals(page)) {
	        List<AccountEntity> employeeList = accountService.findEmployees();
	        model.addAttribute("employees", employeeList);
	        model.addAttribute("page","QLNV");
	        return "/admin/doc/index_admin";  // Return the name of the view to be displayed
	    } else {
	        // Xử lý các trang khác tại đây (nếu có)
	        return "error"; // Ví dụ: Trả về một trang lỗi nếu page không hợp lệ
	    }
	}
	
	@GetMapping("/add_staff/pagecontrol")
	public String getAddPage(@RequestParam("page") String page, Model model) {
	    if ("Add_Staff".equals(page)) {
//	        List<Account> accountList = accountService.getAllAccounts();
//	        model.addAttribute("accounts", accountList);
	        model.addAttribute("page","Add_Staff");
	        return "/admin/doc/index_admin";  // Return the name of the view to be displayed
	    } else {
	        // Xử lý các trang khác tại đây (nếu có)
	        return "error"; // Ví dụ: Trả về một trang lỗi nếu page không hợp lệ
	    }
	}
	@GetMapping("/admin/qlnhanvien/delete/{id}")
	 public String deleteNhanvien(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		accountService.deleteTaikhoan(id);
		redirectAttributes.addAttribute("deleteSuccess", true);
       return "redirect:/staff/pagecontrol?page=QLNV";
   }
}
