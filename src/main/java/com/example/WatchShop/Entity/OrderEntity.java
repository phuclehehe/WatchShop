package com.example.WatchShop.Entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "orders")
public class OrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Order_id;
	@OneToMany(mappedBy = "orders")
	private Set<OrderDetailEntity> listOrderDetails;
	@Column(name = "customer_id")
	private Integer customer_id;
	@Column(name = "order_money")
	private Integer order_money;
	@Column(name = "order_date")
	private String order_date;

	public Integer getOrder_id() {
		return Order_id;
	}

	public void setOrder_id(Integer order_id) {
		Order_id = order_id;
	}

	public Set<OrderDetailEntity> getListOrderDetails() {
		return listOrderDetails;
	}

	public void setListOrderDetails(Set<OrderDetailEntity> listOrderDetails) {
		this.listOrderDetails = listOrderDetails;
	}

	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	public Integer getOrder_money() {
		return order_money;
	}

	public void setOrder_money(Integer order_money) {
		this.order_money = order_money;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}



}
