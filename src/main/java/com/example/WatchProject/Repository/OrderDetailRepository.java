package com.example.WatchProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.WatchProject.Entity.OrderDetailEntity;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Integer>{

}
