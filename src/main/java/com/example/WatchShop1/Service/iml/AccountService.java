package com.example.WatchShop1.Service.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WatchShop1.Entity.AccountEntity;
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
	@Override
	public List<AccountEntity> findAccounts() {
		// TODO Auto-generated method stub
		return accountRepository.findAccounts();
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

}
