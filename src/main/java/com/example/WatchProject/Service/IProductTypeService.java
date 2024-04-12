package com.example.WatchProject.Service;

import com.example.WatchProject.Entity.ProductTypeEntity;

public interface IProductTypeService {
	ProductTypeEntity findByName(int type);
}
