package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.Model.UserEntity;
@Service
public interface UserService {
	UserEntity  findByUsername(String username);
}
