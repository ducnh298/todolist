package com.ducnh.springboot.converter;

import org.springframework.stereotype.Component;

import com.ducnh.springboot.dto.UserDTO;
import com.ducnh.springboot.entity.UserEntity;

@Component
public class UserConverter {
	public UserDTO toDTO(UserEntity entity) {
		UserDTO dto = new UserDTO();

		if (entity.getId() != null)
			dto.setId(entity.getId());
		
		dto.setUserName(entity.getUserName());
		dto.setFullName(entity.getFullName());
		dto.setRole(entity.getRole());
		dto.setPassword(entity.getPassword());
		
		
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setModifiedBy(entity.getModifiedBy());

		return dto;
	}
	
	public UserEntity toEntity(UserDTO dto) {
		UserEntity entity = new UserEntity();
		
		entity.setUserName(dto.getUserName());
		entity.setFullName(dto.getFullName());
		entity.setRole(dto.getRole());
		entity.setPassword(dto.getPassword());
		
		
		entity.setCreatedDate(dto.getCreatedDate());
		entity.setCreatedBy(dto.getCreatedBy());
		entity.setModifiedDate(dto.getModifiedDate());
		entity.setModifiedBy(dto.getModifiedBy());

		return entity;
	}
}
