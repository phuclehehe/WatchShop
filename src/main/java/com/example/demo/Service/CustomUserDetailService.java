package com.example.demo.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Model.CustomUserDetail;
import com.example.demo.Model.User;
import com.example.demo.Model.UserRole;
import com.example.demo.Repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{
	@Autowired
	private UserService userService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user= userService.findByUsername(username);
		if(user==null) {
		throw new UsernameNotFoundException("Not found username"); 
		}
		Collection<GrantedAuthority> authorities= new HashSet<>();
		Set<UserRole> roles=user.getUserRoles();
		for (UserRole userRole : roles) {
			authorities.add(new SimpleGrantedAuthority(userRole.getRole().getName()));
		}
		return new CustomUserDetail(user, authorities);
	}

}
