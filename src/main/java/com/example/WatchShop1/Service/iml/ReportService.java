package com.example.WatchShop1.Service.iml;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WatchShop1.Entity.AccountEntity;
import com.example.WatchShop1.Entity.OrderEntity;
import com.example.WatchShop1.Entity.ProductEntity;
import com.example.WatchShop1.Repository.AccountRepository;
import com.example.WatchShop1.Repository.OrderRepository;
import com.example.WatchShop1.Repository.ProductRepository;


@Service
public class ReportService {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderDetailService orderDetailService;
	
	
	public int getMonthSevenue() {
		LocalDate currentDate = LocalDate.now();
		Date startOfMonth = Date.from(currentDate.withDayOfMonth(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date endOfMonth = Date.from(currentDate.withDayOfMonth(currentDate.lengthOfMonth()).atStartOfDay(ZoneId.systemDefault()).toInstant());
		List<OrderEntity> orders = orderRepository.findByOrderDateBetween(startOfMonth, endOfMonth);
		int totalSevenue = 0;
		for(OrderEntity order : orders) {
			totalSevenue += order.getOrder_money();
		}
		return totalSevenue;
	}
	
	public int getStaffNumber() {
		List<AccountEntity> accounts = accountRepository.findEmployees();
		int staffNumber = accounts.size();
		return staffNumber;
	}
	
	public int getAllProduct() {
		List<ProductEntity> products = productRepository.findAllProducts();
		int productNumber = products.size();
		return productNumber;
	}
	
	public int getOrderAmount() {
		List<OrderEntity> orders = orderRepository.findAll();
		int orderAmount = orders.size();
		return orderAmount;
	}
	
	public int getCancelOrderAmount() {
		List<OrderEntity> orders = orderRepository.findByOrder_status("Đã hủy");
		int cancelOrderAmount = orders.size();
		return cancelOrderAmount;
	}
	
	public int getBanAmount() {
		List<AccountEntity> accounts = accountRepository.findBanAccounts();
		int banAmount = accounts.size();
		return banAmount;
	}
	
	public int getSoldOut() {
		List<ProductEntity> products = productRepository.findSoldOut();
		int soldOut = products.size();
		return soldOut;
	}
}