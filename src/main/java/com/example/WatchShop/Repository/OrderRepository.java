package com.example.WatchShop.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.example.WatchShop.Entity.OrderEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{
	@Query(value="Select * from orders where customer_id= ?1",nativeQuery = true)
	List<OrderEntity> getAllByAccountId(int account_id);
	@Query(value="Select Top 1 * from orders where customer_id= ?1 ORDER BY order_id DESC ",nativeQuery = true)
	OrderEntity getOneByAccountId(int account_id);
}
