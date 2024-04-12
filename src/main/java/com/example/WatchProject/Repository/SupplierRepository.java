package com.example.WatchProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.WatchProject.Entity.SupplierEntity;
@Repository
public interface SupplierRepository extends JpaRepository<SupplierEntity, Integer> {
	SupplierEntity findById(int id);
}
