package com.ducnh.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ducnh.springboot.dto.ToDoDTO;

@Service
public interface IToDoService {
	List<ToDoDTO> findAll();
	ToDoDTO save(ToDoDTO toDoDTo);
	void delete(Long[] ids);
	ToDoDTO findOneById(Long id);
}
