package com.example.WatchShop.Service;

import com.example.WatchShop.Entity.AccountEntity;

public interface IAccountService {
	AccountEntity findByUsername(String username);
	AccountEntity findById(int account_id);
}
