package com.example.WatchShop.Service.iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WatchShop.Entity.PermissionEntity;
import com.example.WatchShop.Repository.PermissionRepository;
import com.example.WatchShop.Service.IPermissonService;

@Service
public class PermissionService implements IPermissonService {
	@Autowired
	private PermissionRepository permissionRepository;

	@Override
	public PermissionEntity findById(int id) {
		return this.permissionRepository.findById(id).get();
	}

}
