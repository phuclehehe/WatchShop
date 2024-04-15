package com.example.WatchProject.Service.iml;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.WatchProject.Entity.AccountEntity;
import com.example.WatchProject.Entity.CustomAccountDetails;
import com.example.WatchProject.Entity.PermissionEntity;

@Service
public class CustomAccountService implements UserDetailsService{
	@Autowired
	private AccountService accountService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AccountEntity account=accountService.findByUsername(username);
		if(account==null) {
			throw new UsernameNotFoundException("Sai");
		}
		Collection<GrantedAuthority> authorities=new HashSet<>();
		PermissionEntity permission=account.getPermission();
		authorities.add(new SimpleGrantedAuthority(permission.getName()));
		return new CustomAccountDetails(account, authorities);
	}

}
