package com.example.QLBDH1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.QLBDH1.Entity.ProductTypeEntity;

public interface ProductTypeRepository extends JpaRepository<ProductTypeEntity, Integer>{
	ProductTypeEntity findById(int id);
}
