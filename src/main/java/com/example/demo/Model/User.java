package com.example.demo.Model;

import java.util.Set;

import org.hibernate.annotations.Comment;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "tb_user")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private Long id;
@Column(name="username")
private String username;
@Column(name = "password")
private String password;
@OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
private Set<UserRole> userRoles;
public User() {
}
public User(Long id, String username, String password, Set<UserRole> userRoles) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
	this.userRoles = userRoles;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String usename) {
	this.username = usename;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Set<UserRole> getUserRoles() {
	return userRoles;
}
public void setUserRoles(Set<UserRole> userRoles) {
	this.userRoles = userRoles;
}

}
