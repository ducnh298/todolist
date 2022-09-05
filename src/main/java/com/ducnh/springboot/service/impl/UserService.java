package com.ducnh.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ducnh.springboot.converter.UserConverter;
import com.ducnh.springboot.dto.UserDTO;
import com.ducnh.springboot.entity.UserEntity;
import com.ducnh.springboot.repository.UserRepository;
import com.ducnh.springboot.service.IUserService;


@Component
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;
	
	public UserDTO save(UserDTO userDTO) {
		UserEntity userEntity= userRepository.save(userConverter.toEntity(userDTO));
		return userConverter.toDTO(userEntity);
	}
	
}
