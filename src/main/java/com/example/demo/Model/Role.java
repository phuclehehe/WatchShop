package com.example.demo.Model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_role")
public class Role {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
private Long id;
@Column(name = "name_role")
private String name;
@OneToMany(mappedBy = "role")
private Set<UserRole> roleUser;
 public Role() {
	// TODO Auto-generated constructor stub
}
public Role(Long id, String name, Set<UserRole> roleUser) {
	super();
	this.id = id;
	this.name = name;
	this.roleUser = roleUser;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Set<UserRole> getRoleUser() {
	return roleUser;
}
public void setRoleUser(Set<UserRole> roleUser) {
	this.roleUser = roleUser;
}
 
}
