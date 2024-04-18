package com.example.WatchProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.WatchProject.Entity.OrderDetailEntity;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Integer>{
	@Query(value="Select * from orderdetail where order_id= ?1",nativeQuery = true)
	List<OrderDetailEntity> getAllByOrderId(int id);
}
