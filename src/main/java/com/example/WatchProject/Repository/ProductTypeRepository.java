package com.example.WatchProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.WatchProject.Entity.ProductTypeEntity;

public interface ProductTypeRepository extends JpaRepository<ProductTypeEntity, Integer>{
	ProductTypeEntity findById(int id);
}
