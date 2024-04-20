package com.example.WatchShop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.WatchShop.Entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer>{
	@Query(value="Select * from account where account_name= ?1",nativeQuery = true)
	AccountEntity findByUsername(String username);
}
