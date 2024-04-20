package com.example.WatchShop.Service;

import com.example.WatchShop.Entity.ProductTypeEntity;

public interface IProductTypeService {
	ProductTypeEntity findByName(int type);
}
