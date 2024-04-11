package com.example.demo.Security;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.hibernate.persister.entity.UnionSubclassEntityPersister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.csrf.CsrfAuthenticationStrategy;

import com.example.demo.Model.CustomUserDetail;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.CustomUserDetailService;
import com.example.demo.Service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private UserDetailsService userDetailsService;
	 @Bean
	 public UserDetailsService userDetailsService() {
	        return userDetailsService();
	    }
	private UserRepository repository;
	@Autowired
	private AuthenticationSucess authenticationSucess;
	@Bean
	public AuthenticationSucess authenticationSucess2() {
		return authenticationSucess2();
	}
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public AuthenticationManager authenticationManager(UserDetailsService userDetailsService) throws Exception{
		DaoAuthenticationProvider authenticationProvider= new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		return new ProviderManager(authenticationProvider);
	}
	@Bean 
	public SecurityFilterChain chain(HttpSecurity http) throws Exception{
		http.csrf(csrf->csrf.disable());
		http.authorizeHttpRequests((auth)->auth
				.requestMatchers("/*").permitAll()
				.requestMatchers("/admin").hasAuthority("ADMIN")
				.anyRequest().authenticated());
		http.formLogin(login->login
				.loginPage("/login")
				.loginProcessingUrl("/login")
				.failureHandler(new AuthenticationFailureHandler() {
					
					@Override
					public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
							AuthenticationException exception) throws IOException, ServletException {
						System.out.println("Failed:" + exception.getMessage());
						
						response.sendRedirect("/login?error");
						
					}
				})
				 .usernameParameter("username")
				 .passwordParameter("password")
				 .defaultSuccessUrl("/*"));
		http.logout(logout->logout
				.logoutSuccessUrl("/*").permitAll()
				);
//		http.sessionManagement(session->session
//				.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
//				.invalidSessionUrl("/invalidSession")
//				.maximumSessions(1)
//				.maxSessionsPreventsLogin(true)
//			
//				.expiredUrl("/expiredSession")
//				);
//		http.addFilter(new AuthFilter(authenticationManagerBean()));
////		http.rememberMe(remember->remember
////				.tokenValiditySeconds(360)
////				.key("selector")
////				);
		
		return http.build();
	}
	@Bean
	WebSecurityCustomizer webSecurityCustomizer() {
		return (web)->web.ignoring().requestMatchers("/assets/**","/css/**","/js/**","/scss/**","/fonts/**","/img/**");
	}
	
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception{
//		return  authenticationManagerBean();
//	}
}
