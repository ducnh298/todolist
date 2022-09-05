package com.ducnh.springboot.dto;

import javax.persistence.Column;

public class CategoryDTO extends BaseDTO{
	private String name;

	private String code;
	
	public CategoryDTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
