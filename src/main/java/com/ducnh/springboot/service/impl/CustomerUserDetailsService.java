package com.ducnh.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ducnh.springboot.converter.UserConverter;
import com.ducnh.springboot.dto.CustomerUserDetails;
import com.ducnh.springboot.entity.UserEntity;
import com.ducnh.springboot.repository.UserRepository;

@Service
public class CustomerUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;
	
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByUserName(userName);
		
		if(user==null) {
			throw new UsernameNotFoundException("User not found!");
		}
		
		CustomerUserDetails customerUserDetails = new CustomerUserDetails(userConverter.toDTO(user));
		customerUserDetails.setUser(userConverter.toDTO(user));
		
		return customerUserDetails;
	}

}
