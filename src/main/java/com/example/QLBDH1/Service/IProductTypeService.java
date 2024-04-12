package com.example.QLBDH1.Service;

import com.example.QLBDH1.Entity.ProductTypeEntity;

public interface IProductTypeService {
	ProductTypeEntity findByName(int type);
}
