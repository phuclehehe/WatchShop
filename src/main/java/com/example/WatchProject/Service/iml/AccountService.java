package com.example.WatchProject.Service.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WatchProject.Entity.AccountEntity;
import com.example.WatchProject.Repository.AccountRepository;
import com.example.WatchProject.Service.IAccountService;

import jakarta.transaction.Transactional;

@Service
public class AccountService implements IAccountService{
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public AccountEntity findByUsername(String username) {
		return this.accountRepository.findByUsername(username);
	}
	@Transactional
	@Override
	public void update(String name, String email, String address, String phone, int id) {
		accountRepository.update(id, email, name, address, phone);
		
	}

	

	
	

//	@Override
//	public List<AccountEntity> getAll() {
//		
//		return this.accountRepository.findAll();
//	}
}
