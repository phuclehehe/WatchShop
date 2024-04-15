package com.example.WatchProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.WatchProject.Entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer>{
	AccountEntity findByUsername(String username);
}
