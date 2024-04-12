package com.example.QLBDH1.Service.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.QLBDH1.Entity.ProductEntity;
import com.example.QLBDH1.Entity.ProductTypeEntity;
import com.example.QLBDH1.Repository.ProductRepository;
import com.example.QLBDH1.Service.IProductService;

@Service
public class ProductService implements IProductService {
	@Autowired
	private ProductRepository productRepository;


	@Override
	public ProductEntity save(ProductEntity product) {
		return this.productRepository.save(product);
	}

	@Override
	public ProductEntity update(ProductEntity product) {
		return product;
	}

	@Override
	public List<ProductEntity> getAll() {
		return this.productRepository.findAll();
	}

	@Override
	public int totalItem() {
		return (int) productRepository.count();
	}


	@Override
	public ProductEntity findByID(int id) {
		return  this.productRepository.findById(id).get();
	}

	@Override
	public List<ProductEntity> searchProduct(String key) {
		return null;
	}

	@Override
	public Page<ProductEntity> getAll(Integer pageNo) {
		Pageable pageable= PageRequest.of(pageNo-1, 1);
		return this.productRepository.findAll(pageable);
	}

	@Override
	public Page<ProductEntity> getAllbyType(Integer pageNo, ProductTypeEntity type) {
		Pageable pageable= PageRequest.of(pageNo-1,1);
		return this.productRepository.findByTypeId(type, pageable);
	}

}
