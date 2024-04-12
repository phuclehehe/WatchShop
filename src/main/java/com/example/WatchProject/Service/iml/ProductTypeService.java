package com.example.WatchProject.Service.iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WatchProject.Entity.ProductTypeEntity;
import com.example.WatchProject.Repository.ProductTypeRepository;
import com.example.WatchProject.Service.IProductTypeService;

@Service
public class ProductTypeService implements IProductTypeService{
	@Autowired
	private ProductTypeRepository productTypeRepository;

	@Override
	public ProductTypeEntity findByName(int typeId) {
		return this.productTypeRepository.findById(typeId);
	}

}
