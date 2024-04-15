package com.example.WatchProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.WatchProject.Entity.AccountEntity;

public interface UserRepository extends JpaRepository<AccountEntity, Long> {
	AccountEntity findByUsername(String username);
	
}