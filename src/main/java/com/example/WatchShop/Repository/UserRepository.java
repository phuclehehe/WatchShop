package com.example.WatchShop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.WatchShop.Entity.AccountEntity;

public interface UserRepository extends JpaRepository<AccountEntity, Long> {
	AccountEntity findByUsername(String username);
	
}