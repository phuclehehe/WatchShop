package com.example.WatchShop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.WatchShop.Entity.ProductTypeEntity;

public interface ProductTypeRepository extends JpaRepository<ProductTypeEntity, Integer>{
	ProductTypeEntity findById(int id);
}
