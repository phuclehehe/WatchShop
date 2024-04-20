package com.example.WatchShop.Service.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WatchShop.Entity.OrderEntity;
import com.example.WatchShop.Repository.OrderRepository;
import com.example.WatchShop.Service.IOrderService;

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
	@Override
	public OrderEntity getOneById(int id) {
		try {
			OrderEntity orderEntity=this.orderRepository.getOneByAccountId(id);
			return orderEntity;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<OrderEntity> getAllByAccountId(int account_id) {
		try {
			List<OrderEntity> list=this.orderRepository.getAllByAccountId(account_id);
			return list;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
