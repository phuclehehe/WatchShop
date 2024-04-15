package com.example.demo.Model;

import java.util.Set;

import org.hibernate.bytecode.enhance.spi.EnhancementInfo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "account_permission")
public class RoleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "permission")
	private Integer id;
	@Column(name = "permission_name")
	private String permission_name;
	@OneToMany (mappedBy = "role")
	private Set<UserEntity> role;
	public RoleEntity() {
		
	}
	public RoleEntity(Integer id, String permission_name, Set<UserEntity> role) {
		super();
		this.id = id;
		this.permission_name = permission_name;
		this.role = role;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPermission_name() {
		return permission_name;
	}
	public void setPermission_name(String permission_name) {
		this.permission_name = permission_name;
	}
	public Set<UserEntity> getRole() {
		return role;
	}
	public void setRole(Set<UserEntity> role) {
		this.role = role;
	}
	
}
