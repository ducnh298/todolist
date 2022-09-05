package com.ducnh.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ducnh.springboot.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{

	public CategoryEntity findOneByCode(String code);
}
