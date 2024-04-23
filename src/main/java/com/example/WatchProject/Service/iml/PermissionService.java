package com.example.WatchProject.Service.iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WatchProject.Entity.PermissionEntity;
import com.example.WatchProject.Repository.PermissionRepository;
import com.example.WatchProject.Service.IPermissonService;

@Service
public class PermissionService implements IPermissonService {
	@Autowired
	private PermissionRepository permissionRepository;

	@Override
	public PermissionEntity findById(int id) {
		return this.permissionRepository.findById(id).get();
	}

}
