package com.ducnh.springboot.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class CategoryEntity extends BaseEntity{
	@Column
	private String name;
	
	@Column
	private String code;
	
	@OneToMany(mappedBy = "category")
	private List<ToDoEntity> toDoList = new ArrayList<ToDoEntity>();

	public CategoryEntity() {
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

	public List<ToDoEntity> getToDoList() {
		return toDoList;
	}

	public void setToDoList(List<ToDoEntity> toDoList) {
		this.toDoList = toDoList;
	}
	
	
}
