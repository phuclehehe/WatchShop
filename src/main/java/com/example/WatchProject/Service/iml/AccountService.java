package com.example.WatchProject.Service.iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WatchProject.Entity.AccountEntity;
import com.example.WatchProject.Repository.AccountRepository;
import com.example.WatchProject.Service.IAccountService;

@Service
public class AccountService implements IAccountService{
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public AccountEntity findByUsername(String username) {
		return this.accountRepository.findByUsername(username);
	}

}
