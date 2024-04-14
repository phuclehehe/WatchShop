package com.example.WatchProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.WatchProject.Entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{

}
