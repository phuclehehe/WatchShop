package com.example.WatchProject.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Account")
public class AccountEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private Integer account_id;
	@Column(name = "account_name")
	private String username;
	@Column(name = "account_password")
	private String password;
	@Column(name = "customer_name")
	private String customer_name;
	@Column(name = "customer_phone")
	private String customer_phone;
	@Column(name = "customer_address")
	private String customer_address;
	@Column(name = "customer_email")
	private String customer_email;
	@ManyToOne
	@JoinColumn(name = "permission_id")
	private PermissionEntity permission;

	public AccountEntity() {
	}

	public Integer getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
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

	public PermissionEntity getPermission() {
		return permission;
	}

	public void setPermission(PermissionEntity permission) {
		this.permission = permission;
	}

}
