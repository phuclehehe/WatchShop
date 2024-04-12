package com.example.WatchProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.WatchProject.Entity.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, Integer>{
	@Query(value="Delete from cart where account_id= ?1",nativeQuery = true)
	Boolean delProductCart(int account_id);
	
	@Query(value="Select * from cart where account_id= ?1",nativeQuery = true)
	List<CartEntity> listCart(int account_id);
	
	@Query(value="Select sum(product_quantity*p.product_saleprice) from cart as c, product as p where account_id= ?1 and c.product_id=p.product_id ",nativeQuery = true)
	int Total(int account_id);
	
	
}
