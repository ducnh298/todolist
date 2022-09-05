package com.ducnh.springboot.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserEntity extends BaseEntity{
	@Column(name="username")
	private String userName;
	
	@Column
	private String password;
	
	@Column(name="fullname")
	private String fullName;
	
	@Column
	private String role;
	
	@OneToMany(mappedBy = "user")
	private List<ToDoEntity> toDoList = new ArrayList<ToDoEntity>();
	
	
	public UserEntity() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public List<ToDoEntity> getToDoList() {
		return toDoList;
	}

	public void setToDoList(List<ToDoEntity> toDoList) {
		this.toDoList = toDoList;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
