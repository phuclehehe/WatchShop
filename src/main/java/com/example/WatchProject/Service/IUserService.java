package com.example.WatchProject.Service;

import org.springframework.stereotype.Service;

import com.example.WatchProject.Entity.AccountEntity;
@Service
public interface IUserService{
	AccountEntity findByUsername(String username);
	

}
