package com.example.WatchProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.WatchProject.Entity.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, Integer>{
	@Modifying
	@Query(value = "Delete from cart where account_id= ?1", nativeQuery = true)
	void delProductCart(int account_id);

	@Query(value = "Select * from cart where account_id= ?1", nativeQuery = true)
	List<CartEntity> listCart(int account_id);

	@Query(value = "Select sum(product_quantity*p.product_saleprice) from cart as c, product as p where account_id= ?1 and c.product_id=p.product_id ", nativeQuery = true)
	int Total(int account_id);
	@Modifying
	@Query(value = "update cart set product_quantity= ?1 where product_id= ?2", nativeQuery = true)
	void updateProductCart(int quantity, int product_id);

	@Query(value = "Select * from cart where product_id= ?1 and account_id= ?2", nativeQuery = true)
	CartEntity findProductFromCart(int product_id, int account_id);
	@Modifying
	@Query(value = "Delete from cart where account_id= ?1 and product_id= ?2", nativeQuery = true)
	void delOneProductCart(int account_id, int product_id);
	
	
}
