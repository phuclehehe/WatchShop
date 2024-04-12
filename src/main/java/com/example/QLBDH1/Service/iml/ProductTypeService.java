package com.example.QLBDH1.Service.iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.QLBDH1.Entity.ProductTypeEntity;
import com.example.QLBDH1.Repository.ProductTypeRepository;
import com.example.QLBDH1.Service.IProductTypeService;

@Service
public class ProductTypeService implements IProductTypeService{
	@Autowired
	private ProductTypeRepository productTypeRepository;

	@Override
	public ProductTypeEntity findByName(int typeId) {
		return this.productTypeRepository.findById(typeId);
	}

}
