package com.example.WatchProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.WatchProject.Entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{
	@Query(value="Select * from orders where customer_id= ?1 ",nativeQuery = true)
	List<OrderEntity> getAllByAccountId(int account_id);
	@Query(value="Select  * from orders where customer_id= ?1 ORDER BY order_id DESC LIMIT 1",nativeQuery = true)
	OrderEntity getOneByAccountId(int account_id);
}
