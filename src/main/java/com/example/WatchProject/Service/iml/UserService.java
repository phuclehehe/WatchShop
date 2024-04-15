package com.example.WatchProject.Service.iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WatchProject.Entity.AccountEntity;
import com.example.WatchProject.Repository.UserRepository;
import com.example.WatchProject.Service.IUserService;

@Service
public class UserService implements IUserService{
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public AccountEntity findByUsername(String username) {
		
		return userRepo.findByUsername(username);
	}

	
}
