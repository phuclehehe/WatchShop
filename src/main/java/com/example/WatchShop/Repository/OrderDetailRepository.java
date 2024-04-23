package com.example.WatchShop.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.WatchShop.Entity.OrderDetailEntity;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Integer>{
	@Query(value="Select * from Order_details where order_id= ?1",nativeQuery = true)
	List<OrderDetailEntity> getAllByOrderId(int id);
	@Query(value="Select Top 1  * from Order_details where order_id= ?1 ORDER BY order_id DESC",nativeQuery = true)
	OrderDetailEntity getOneByOrderID(int order_id);
}
