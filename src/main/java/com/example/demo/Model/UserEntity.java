package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Account")
public class UserEntity {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name="account_id")
	private Integer id;
	@Column(name = "account_name")
	private String username;
	@Column(name = "account_password")
	private String password;
	@ManyToOne
	@JoinColumn(name = "account_permission")
	private RoleEntity role;
	public UserEntity() {
		
	}
	public UserEntity(Integer id, String username, String password, RoleEntity role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public RoleEntity getRole() {
		return role;
	}
	public void setRole(RoleEntity role) {
		this.role = role;
	}
	
}
