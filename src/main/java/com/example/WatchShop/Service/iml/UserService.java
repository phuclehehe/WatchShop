package com.example.WatchShop.Service.iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WatchShop.Entity.AccountEntity;
import com.example.WatchShop.Repository.UserRepository;
import com.example.WatchShop.Service.IUserService;

@Service
public class UserService implements IUserService{
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public AccountEntity findByUsername(String username) {
		
		return userRepo.findByUsername(username);
	}

	
}
