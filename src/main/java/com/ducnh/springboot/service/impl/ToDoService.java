package com.ducnh.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducnh.springboot.converter.ToDoConverter;
import com.ducnh.springboot.dto.ToDoDTO;
import com.ducnh.springboot.entity.CategoryEntity;
import com.ducnh.springboot.entity.ToDoEntity;
import com.ducnh.springboot.repository.CategoryRepository;
import com.ducnh.springboot.repository.ToDoRepository;
import com.ducnh.springboot.service.IToDoService;

@Service
public class ToDoService implements IToDoService{

	@Autowired
	ToDoRepository toDoRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ToDoConverter toDoConverter;
	
	public List<ToDoDTO> findAll() {
		List<ToDoDTO> result = new ArrayList<ToDoDTO>();
		List<ToDoEntity> listEntity = toDoRepository.findAll();
		for(ToDoEntity todo:listEntity)
			result.add(toDoConverter.toDTO(todo));
		
		return result;
	}

	public ToDoDTO save(ToDoDTO toDoDTO) {
		
		ToDoEntity toDoEntity = new ToDoEntity();
		
		if(toDoDTO.getId()!=null) {
			ToDoEntity oldToDo = null;
			try {
				oldToDo = toDoRepository.findById(toDoDTO.getId()).orElse(null);
				toDoEntity = toDoConverter.toEntity(toDoDTO, oldToDo);
				if(toDoEntity.getStatus()==0)
					toDoEntity.setCompletedDate(null);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else 
			toDoEntity= toDoConverter.toEntity(toDoDTO);
		
		CategoryEntity category = categoryRepository.findOneByCode(toDoDTO.getCategoryCode());
		toDoEntity.setCategory(category);
		toDoRepository.save(toDoEntity);
		
		return toDoConverter.toDTO(toDoEntity);
	}

	public void delete(Long[] ids) {
		for(Long id: ids)
			toDoRepository.deleteById(id);
	}

	public ToDoDTO findOneById(Long id) {
		ToDoEntity result = toDoRepository.findById(id).orElse(null);
		return toDoConverter.toDTO(result);
	}

}
