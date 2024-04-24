package com.example.WatchShop1.Service.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WatchShop1.Entity.AccountDTO;
import com.example.WatchShop1.Entity.AccountEntity;
import com.example.WatchShop1.Entity.OrderDetailEntity;
import com.example.WatchShop1.Entity.PermissionEntity;
import com.example.WatchShop1.Repository.AccountRepository;
import com.example.WatchShop1.Service.IAccountService;

import jakarta.transaction.Transactional;

@Service
public class AccountService implements IAccountService {
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public AccountEntity findByUsername(String username) {
		return this.accountRepository.findByUsername(username);
	}

	@Override
	public AccountEntity findById(int account_id) {
		return this.accountRepository.findById(account_id).get();
	}

	@Transactional
	@Override
	public void update(String name, String email, String address, String phone, int id) {
		accountRepository.update(id, email, name, address, phone);

	}
	public List<AccountEntity> findAccounts() {
		try {
			List<AccountEntity> list=this.accountRepository.findAccounts();
			return list;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<AccountEntity> findEmployees() {
		// TODO Auto-generated method stub
		return accountRepository.findEmployees();
	}
	@Override
	public List<AccountEntity> findCustomers() {
		// TODO Auto-generated method stub
		return accountRepository.findCustomers();
	}
	@Override
    public void deleteTaikhoan(Integer id) {
        AccountEntity account = accountRepository.findById(id).orElse(null);
        if (account != null) {
        	account.setIs_deleted(1);
        	accountRepository.save(account);
        }
    }
	@Override
	public void creatCustomer(AccountDTO accountDTO) {
		AccountEntity account = new AccountEntity();
		account.setUsername(accountDTO.getAccount_name());
		account.setPassword(accountDTO.getAccount_password());
		account.setCustomer_name(accountDTO.getCustomer_name());
		account.setCustomer_phone(accountDTO.getCustomer_phone());
		account.setCustomer_address(accountDTO.getCustomer_address());
		account.setCustomer_email(accountDTO.getCustomer_email());
		PermissionEntity accountRole = new PermissionEntity();
		accountRole.setPermission_id(3);
		account.setPermission(accountRole);
		account.setIs_deleted(0);
		accountRepository.save(account);
	}
	@Override
	public void creatStaff(AccountDTO accountDTO) {
		AccountEntity account = new AccountEntity();
		account.setUsername(accountDTO.getAccount_name());
		account.setPassword(accountDTO.getAccount_password());
		account.setCustomer_name(accountDTO.getCustomer_name());
		account.setCustomer_phone(accountDTO.getCustomer_phone());
		account.setCustomer_address(accountDTO.getCustomer_address());
		account.setCustomer_email(accountDTO.getCustomer_email());
		PermissionEntity accountRole = new PermissionEntity();
		accountRole.setPermission_id(2);
		account.setPermission(accountRole);
		account.setIs_deleted(0);
		accountRepository.save(account);
		
	}
	@Override
	public void creatAccount(AccountDTO accountDTO) {
		AccountEntity account = new AccountEntity();
		account.setUsername(accountDTO.getAccount_name());
		account.setPassword(accountDTO.getAccount_password());
		account.setCustomer_name(accountDTO.getCustomer_name());
		account.setCustomer_phone(accountDTO.getCustomer_phone());
		account.setCustomer_address(accountDTO.getCustomer_address());
		account.setCustomer_email(accountDTO.getCustomer_email());
		PermissionEntity accountRole = new PermissionEntity();
		accountRole.setPermission_id(accountDTO.getPermission_id());
		account.setPermission(accountRole);
		account.setIs_deleted(0);
		accountRepository.save(account);
		
	}
	@Override
	public void updateCustomer(AccountDTO accountDTO) {
		try {
	        AccountEntity account = accountRepository.findById(accountDTO.getAccount_id())
	                .orElseThrow(() -> new RuntimeException("Không tìm thấy khách hàng với ID " + accountDTO.getAccount_id()));
	        account.setCustomer_name(accountDTO.getCustomer_name());
	        account.setCustomer_phone(accountDTO.getCustomer_phone());
	        account.setCustomer_address(accountDTO.getCustomer_address());
	        account.setCustomer_email(accountDTO.getCustomer_email());
	        
	        accountRepository.save(account);
	    } catch (Exception e) {
	        
	        e.printStackTrace();
	    }
		
	}
	@Override
	public void updateAccount(AccountDTO accountDTO) {
		try {
	        AccountEntity account = accountRepository.findById(accountDTO.getAccount_id())
	                .orElseThrow(() -> new RuntimeException("Không tìm thấy tài khoản với ID " + accountDTO.getAccount_id()));
	        account.setCustomer_name(accountDTO.getCustomer_name());
	        account.setCustomer_phone(accountDTO.getCustomer_phone());
	        account.setCustomer_address(accountDTO.getCustomer_address());
	        account.setCustomer_email(accountDTO.getCustomer_email());
	        account.setPassword(accountDTO.getAccount_password());
	        PermissionEntity accountRole = new PermissionEntity();
	        accountRole.setPermission_id(accountDTO.getPermission_id());
	        account.setPermission(accountRole);
	        // Lưu sản phẩm vào cơ sở dữ liệu sau khi cập nhật thông tin
	        accountRepository.save(account);
	    } catch (Exception e) {
	        // Xử lý lỗi khi update không thành công và hiển thị thông báo lỗi
	        e.printStackTrace();
	        // Đoạn mã xử lý thông báo lỗi ở đây, ví dụ: log lỗi, hiển thị thông báo cho người dùng, v.v.
	    }
		
	}
	@Override
	public void updateStaff(AccountDTO accountDTO) {
		try {
	        AccountEntity account = accountRepository.findById(accountDTO.getAccount_id())
	                .orElseThrow(() -> new RuntimeException("Không tìm thấy nhân viên với ID " + accountDTO.getAccount_id()));
	        account.setCustomer_name(accountDTO.getCustomer_name());
	        account.setCustomer_phone(accountDTO.getCustomer_phone());
	        account.setCustomer_address(accountDTO.getCustomer_address());
	        account.setCustomer_email(accountDTO.getCustomer_email());
	        // Lưu sản phẩm vào cơ sở dữ liệu sau khi cập nhật thông tin
	        accountRepository.save(account);
	    } catch (Exception e) {
	        // Xử lý lỗi khi update không thành công và hiển thị thông báo lỗi
	        e.printStackTrace();
	        // Đoạn mã xử lý thông báo lỗi ở đây, ví dụ: log lỗi, hiển thị thông báo cho người dùng, v.v.
	    }
		
	}

}
