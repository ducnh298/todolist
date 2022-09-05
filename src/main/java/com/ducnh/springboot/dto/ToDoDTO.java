package com.ducnh.springboot.dto;

import java.sql.Timestamp;


public class ToDoDTO extends BaseDTO{
	private String title;

	private String content;

	private int status;
	
	private Timestamp completedDate;
	
	private String categoryCode;
	
	private Long userId;
	
	private CategoryDTO category;

	public ToDoDTO() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public Timestamp getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Timestamp completedDate) {
		this.completedDate = completedDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}
	
	
}
