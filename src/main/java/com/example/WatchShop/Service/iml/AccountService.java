package com.example.WatchShop.Service.iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WatchShop.Entity.AccountEntity;
import com.example.WatchShop.Repository.AccountRepository;
import com.example.WatchShop.Service.IAccountService;

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

}
