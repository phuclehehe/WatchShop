package com.example.QLBDH1.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.QLBDH1.Entity.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, Integer>{
	@Query(value="Delete from cart where account_id= ?1",nativeQuery = true)
	Boolean delProductCart(int account_id);
	
	@Query(value="Select * from cart where account_id= ?1",nativeQuery = true)
	List<CartEntity> listCart(int account_id);
	
	@Query(value="Select sum(product_quantity*product_saleprice) from cart where account_id= ?1",nativeQuery = true)
	int Total(int account_id);
	
	
}
