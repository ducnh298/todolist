package com.ducnh.springboot.converter;

import org.springframework.stereotype.Component;

import com.ducnh.springboot.dto.CategoryDTO;
import com.ducnh.springboot.entity.CategoryEntity;

@Component
public class CategoryConverter {

	public CategoryDTO toDTO(CategoryEntity entity) {
		CategoryDTO dto=new CategoryDTO();
		
		if(entity.getId()!=null)
			dto.setId(entity.getId());
		
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		
		return dto;
	}
	
	
	public CategoryEntity toEntity(CategoryDTO dto) {
		CategoryEntity entity = new CategoryEntity();
		
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		
		return entity;
	}
	
	public CategoryEntity toEntity(CategoryDTO dto,CategoryEntity entity) {
		
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		
		return entity;
	}
}
