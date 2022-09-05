package com.ducnh.springboot.converter;

import org.springframework.stereotype.Component;

import com.ducnh.springboot.dto.ToDoDTO;
import com.ducnh.springboot.entity.ToDoEntity;

@Component
public class ToDoConverter {

	public ToDoDTO toDTO(ToDoEntity entity) {
		ToDoDTO dto=new ToDoDTO();
		
		if(entity.getId()!=null)
			dto.setId(entity.getId());
		
		dto.setTitle(entity.getTitle());
		dto.setContent(entity.getContent());
		dto.setCategoryCode(entity.getCategory().getCode());
		dto.setStatus(entity.getStatus());
		dto.setCompletedDate(entity.getCompletedDate());
		if(entity.getUser()!=null)
			dto.setUserId(entity.getUser().getId());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		
		return dto;
	}
	
	
	public ToDoEntity toEntity(ToDoDTO dto) {
		ToDoEntity entity = new ToDoEntity();
		
		entity.setTitle(dto.getTitle());
		entity.setContent(dto.getContent());
		entity.setStatus(dto.getStatus());
		entity.setCompletedDate(dto.getCompletedDate());
		
		return entity;
	}
	
	public ToDoEntity toEntity(ToDoDTO dto,ToDoEntity entity) {
		
		entity.setTitle(dto.getTitle());
		entity.setContent(dto.getContent());
		entity.setStatus(dto.getStatus());
		entity.setCompletedDate(dto.getCompletedDate());
		
		return entity;
	}
}
