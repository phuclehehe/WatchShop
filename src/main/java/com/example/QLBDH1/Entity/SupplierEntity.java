package com.example.QLBDH1.Entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "supplier")
public class SupplierEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer supplier_id;
	@Column(name = "supplier_name")
	private String supllierName;
	
	@OneToMany(mappedBy = "supplierEntity")
	private Set<ProductEntity> products;

	public String getSupllierName() {
		return supllierName;
	}

	public void setSupllierName(String supllierName) {
		this.supllierName = supllierName;
	}

	public Integer getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(Integer supplier_id) {
		this.supplier_id = supplier_id;
	}

	public Set<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductEntity> products) {
		this.products = products;
	}
	
	
	
}
