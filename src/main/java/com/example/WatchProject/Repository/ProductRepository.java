package com.example.WatchProject.Repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.WatchProject.Entity.ProductEntity;
import com.example.WatchProject.Entity.ProductTypeEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{
	@Query(value="SELECT * from product p where p.product_name like %?1%",nativeQuery = true)
	List<ProductEntity> searchProduct (String key);
	
	Page<ProductEntity> findByTypeId(ProductTypeEntity typeId,Pageable pageable);

}
