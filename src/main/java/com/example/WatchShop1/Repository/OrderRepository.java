package com.example.WatchShop1.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.WatchShop1.Entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{
	@Query(value="Select * from orders where customer_id= ?1",nativeQuery = true)
	List<OrderEntity> getAllByAccountId(int account_id);
	@Query(value="Select Top 1 * from orders where customer_id= ?1 ORDER BY order_id DESC ",nativeQuery = true)
	OrderEntity getOneByAccountId(int account_id);
	
}
