package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepo;

	@Override
	public User findByUsername(String username) {
		
		return userRepo.findByUsername(username);
	}

	
}

