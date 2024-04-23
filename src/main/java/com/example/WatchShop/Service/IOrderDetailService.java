package com.example.WatchShop.Service;

import java.util.List;

import com.example.WatchShop.Entity.OrderDetailEntity;

public interface IOrderDetailService {
	Boolean AddtoOrderDetail(OrderDetailEntity orderDetailEntity);
	List<OrderDetailEntity> getByOrderId(int order_id);
	OrderDetailEntity getOneByOrderID(int order_id);
}
