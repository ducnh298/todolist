package com.ducnh.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ducnh.springboot.entity.ToDoEntity;

public interface ToDoRepository extends JpaRepository<ToDoEntity, Long>{

}
