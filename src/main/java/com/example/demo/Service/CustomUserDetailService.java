package com.example.demo.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Model.CustomUserDetail;
import com.example.demo.Model.RoleEntity;
import com.example.demo.Model.UserEntity;

@Service
public class CustomUserDetailService implements UserDetailsService{
	@Autowired
	private UserService service;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user= service.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("Not found username");
		}
		Collection<GrantedAuthority> authorities=new HashSet<>();
		RoleEntity role=user.getRole();
		if(role!=null) {
			authorities.add(new SimpleGrantedAuthority(role.getPermission_name()));
		}
		return new CustomUserDetail(user, authorities);
	}

}
