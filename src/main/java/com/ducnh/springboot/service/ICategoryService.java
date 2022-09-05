package com.ducnh.springboot.service;

import org.springframework.stereotype.Service;

import com.ducnh.springboot.dto.CategoryDTO;

@Service
public interface ICategoryService {
	CategoryDTO findByCode(String code);
}
