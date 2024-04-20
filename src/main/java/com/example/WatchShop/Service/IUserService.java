package com.example.WatchShop.Service;

import org.springframework.stereotype.Service;

import com.example.WatchShop.Entity.AccountEntity;
@Service
public interface IUserService{
	AccountEntity findByUsername(String username);
	

}
