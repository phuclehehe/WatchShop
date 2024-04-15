package com.example.WatchProject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class test {
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		String passwordString="123456789";
		String encodeString1=encoder.encode(passwordString);
		System.out.println(encodeString1);
	}
}
