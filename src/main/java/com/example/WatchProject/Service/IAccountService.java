package com.example.WatchProject.Service;

import com.example.WatchProject.Entity.AccountEntity;

public interface IAccountService {
	AccountEntity findByUsername(String username);

}
