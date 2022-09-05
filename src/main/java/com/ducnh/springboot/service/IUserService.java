package com.ducnh.springboot.service;

import org.springframework.stereotype.Component;

import com.ducnh.springboot.dto.UserDTO;

@Component
public interface IUserService {
	UserDTO save(UserDTO userDTO);
}
