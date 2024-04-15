package com.example.WatchProject.Service.iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WatchProject.Entity.OrderEntity;
import com.example.WatchProject.Repository.OrderRepository;
import com.example.WatchProject.Service.IOrderService;

@Service
public class OrderService implements IOrderService{
	@Autowired
	private OrderRepository orderRepository;
	@Override
	public Boolean AddtoOrder(OrderEntity orderEntity) {
		try {
			this.orderRepository.save(orderEntity);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
