package com.example.WatchProject.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.WatchProject.Service.iml.CustomAccountService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private CustomAccountService accountService;
	@Bean 
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	SecurityFilterChain filterChain (HttpSecurity httpSecurity) throws Exception{
		httpSecurity.csrf(csrf -> csrf.disable()).authorizeHttpRequests((auth)-> auth
				.requestMatchers("/*").permitAll()
				.requestMatchers("/admin/**").hasAuthority("ADMIN")
				.anyRequest().authenticated()).formLogin(login->login.loginPage("/login").loginProcessingUrl("/login")
						.usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/admin"));
		return httpSecurity.build();
	}
	@Bean
	WebSecurityCustomizer webSecurityCustomizer() {
		return (web)->web.ignoring().requestMatchers("/static/**","/assets/**");
	}
}
