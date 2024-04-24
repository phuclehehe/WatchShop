package com.example.WatchShop1.Service;

import java.util.List;

import com.example.WatchShop1.Entity.AccountEntity;

public interface IAccountService {
	AccountEntity findByUsername(String username);
	AccountEntity findById(int account_id);
	void update(String name,String email, String address, String phone,int id);
	List<AccountEntity> findAccounts();
	List<AccountEntity> findEmployees();
	List<AccountEntity> findCustomers();
	void deleteTaikhoan(Integer id);
}
