package com.example.WatchShop.Service.iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WatchShop.Entity.AccountEntity;
import com.example.WatchShop.Repository.AccountRepository;
import com.example.WatchShop.Service.IAccountService;

@Service
public class AccountService implements IAccountService{
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

}
