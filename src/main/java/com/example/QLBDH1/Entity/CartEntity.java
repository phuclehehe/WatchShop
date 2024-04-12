package com.example.QLBDH1.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class CartEntity {
	@Id
	@Column(name="product_id")
	private Integer product_id;
	@Column(name = "account_id")
	private Integer account_id;
	@Column(name = "product_quantity")
	private Integer product_quantity;
	@Column(name = "product_saleprice")
	private Integer product_saleprice;

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public Integer getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
	}

	public Integer getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(Integer product_quantity) {
		this.product_quantity = product_quantity;
	}

	public Integer getProduct_saleprice() {
		return product_saleprice;
	}

	public void setProduct_saleprice(Integer product_saleprice) {
		this.product_saleprice = product_saleprice;
	}

}
