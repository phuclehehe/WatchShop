package com.example.WatchShop.Service.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WatchShop.Entity.OrderDetailEntity;
import com.example.WatchShop.Repository.OrderDetailRepository;
import com.example.WatchShop.Service.IOrderDetailService;

@Service
public class OrderDetailService implements IOrderDetailService{
	@Autowired
	private OrderDetailRepository detailRepository;
	@Override
	public Boolean AddtoOrderDetail(OrderDetailEntity orderDetailEntity) {
		try {
			this.detailRepository.save(orderDetailEntity);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<OrderDetailEntity> getByOrderId(int order_id) {
		try {
			List<OrderDetailEntity> list=this.detailRepository.getAllByOrderId(order_id);
			return list;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public OrderDetailEntity getOneByOrderID(int order_id) {
		return this.detailRepository.getOneByOrderID(order_id);
	}
}
