package com.example.demo.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.UserEntity;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired 
	private UserRepository repository;
	@Override
	public UserEntity findByUsername(String username) {
		
		return repository.findByUsername(username);
	}

}
