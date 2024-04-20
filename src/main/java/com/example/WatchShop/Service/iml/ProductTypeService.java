package com.example.WatchShop.Service.iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WatchShop.Entity.ProductTypeEntity;
import com.example.WatchShop.Repository.ProductTypeRepository;
import com.example.WatchShop.Service.IProductTypeService;

@Service
public class ProductTypeService implements IProductTypeService{
	@Autowired
	private ProductTypeRepository productTypeRepository;

	@Override
	public ProductTypeEntity findByName(int typeId) {
		return this.productTypeRepository.findById(typeId);
	}

}
