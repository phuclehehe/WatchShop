package com.example.WatchProject.Service;

import java.util.List;

import com.example.WatchProject.Entity.OrderDetailEntity;

public interface IOrderDetailService {
	Boolean AddtoOrderDetail(OrderDetailEntity orderDetailEntity);
	List<OrderDetailEntity> getByOrderId(int order_id);
}
