package com.example.WatchProject.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.WatchProject.Entity.ProductEntity;
import com.example.WatchProject.Entity.ProductTypeEntity;

public interface IProductService {
	ProductEntity save(ProductEntity product);
	ProductEntity update(ProductEntity product);
	List<ProductEntity> getAll();
	List<ProductEntity> searchProduct(String key);
	ProductEntity findByID(int id);
	int totalItem();
	Page<ProductEntity> getAll(Integer pageNo);
	Page<ProductEntity> getAllbyType(Integer pageNo,ProductTypeEntity Type);
	void updateInventoryProduct(int quantity,int product_id);
}
