package com.example.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		String passwordString="123456";
		String passwordString1="12345";
		String passwordString2="123457";
		String encodeString1=encoder.encode(passwordString1);
		System.out.println(encodeString1);
	}
}
