package com.ducnh.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducnh.springboot.converter.CategoryConverter;
import com.ducnh.springboot.dto.CategoryDTO;
import com.ducnh.springboot.entity.CategoryEntity;
import com.ducnh.springboot.repository.CategoryRepository;
import com.ducnh.springboot.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService{

	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	CategoryConverter categoryConverter;
	
	public CategoryDTO findByCode(String code) {
		CategoryDTO result = new CategoryDTO();
		CategoryEntity categoryEntity= categoryRepository.findOneByCode(code);
		result=categoryConverter.toDTO(categoryEntity);
		return result;
	}

}
