package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
@SessionScope
public class CookiesService {
	@Autowired
	private HttpServletResponse response;
	@Autowired
	private HttpServletRequest request;
	public Cookie addCookie( String name,String value,int maxAge) {
		Cookie cookie= new Cookie(name, value);
		cookie.setMaxAge(maxAge *60^60);
		cookie.setPath("/");
		response.addCookie(cookie);
		return cookie;
	}
	public String getCookie(String name) {
		Cookie[] cookies= request.getCookies();
		if(cookies!=null) {
			for(Cookie cookie:cookies) {
				if(cookie.getName().equalsIgnoreCase(name)) {
				return cookie.getValue();	
				}
			}
		}
		return "";
	}
	public Cookie removeCookie(String name) {
//		Cookie cookie= new Cookie(name, null);
//		cookie.setMaxAge(0);
//		cookie.setPath("/");
		Cookie[] cookies= request.getCookies();
		if(cookies!=null) {
			for(Cookie cookie:cookies) {
				if(cookie.getName().equalsIgnoreCase(name)) {
					cookie.setMaxAge(0);
					cookie.setPath("/");
					return cookie;
				}
			}
			
		}
		return null;
	}
}
