package com.example.WatchProject.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.example.WatchProject.Entity.AccountEntity;

import jakarta.transaction.Transactional;




@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer>{
	
	@Modifying
	@Query(value="UPDATE account SET customer_email = ?2, customer_name = ?3, customer_address = ?4, customer_phone = ?5 WHERE account_id = ?1", nativeQuery = true)
    void update(int id, String email, String name, String address, String phone);
	
	
	@Query(value="Select * from account where account_name= ?1",nativeQuery = true)
	AccountEntity findByUsername(String username);
	
	
    

	

}
