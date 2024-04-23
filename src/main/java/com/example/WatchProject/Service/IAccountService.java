package com.example.WatchProject.Service;

import java.util.List;

import com.example.WatchProject.Entity.AccountEntity;

public interface IAccountService {
	AccountEntity findByUsername(String username);
//	List<AccountEntity> list
	 void update(String name,String email, String address, String phone,int id);

}
