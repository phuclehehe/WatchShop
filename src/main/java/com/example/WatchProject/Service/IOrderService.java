package com.example.WatchProject.Service;

import java.util.List;

import com.example.WatchProject.Entity.OrderEntity;

public interface IOrderService {
	Boolean AddtoOrder(OrderEntity orderEntity);
	OrderEntity getOneById(int id);
	List<OrderEntity> getAllByAccountId(int account_id);
}
