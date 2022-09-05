package com.ducnh.springboot.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ducnh.springboot.dto.ToDoDTO;
import com.ducnh.springboot.dto.UserDTO;
import com.ducnh.springboot.entity.ToDoEntity;
import com.ducnh.springboot.repository.ToDoRepository;
import com.ducnh.springboot.service.ICategoryService;
import com.ducnh.springboot.service.IToDoService;
import com.ducnh.springboot.service.IUserService;
import com.ducnh.springboot.utils.SecurityUtils;

@Controller
public class ToDoController {

	@Autowired
	IToDoService toDoService;

	@Autowired
	ICategoryService categoryService;
	
	@Autowired
	IUserService userService;

	@GetMapping(value = "/")
	public String homePage() {
		return "redirect:/todo";
	}

	@GetMapping(value = "/admin")
	public String adminPage() {
		return "admin";
	}

	@GetMapping(value = "/home")
	public String homeUserPage() {
		return "home";
	}
	
	@GetMapping(value = "/todo")
	public String getToDo(Model model) {
		List<ToDoDTO> listToDoEntity = toDoService.findAll();
		
//		UserDTO user = new UserDTO();
//		user.setUserName(SecurityUtils.getPrincipal().getUserName());
//		user.setId(SecurityUtils.getPrincipal().getId());
//		user.setFullName(SecurityUtils.getPrincipal().getFullName());
		
		for (ToDoDTO todo : listToDoEntity) {
			todo.setCategory(categoryService.findByCode(todo.getCategoryCode()));
		}
		model.addAttribute("todos", listToDoEntity);
//		model.addAttribute("user",user);
		return "todos";
	}

	@GetMapping(value = "/todo/new")
	public String createToDoForm(Model model) {
		ToDoDTO toDoDTO = new ToDoDTO();
		model.addAttribute("todo", toDoDTO);
		return "create_todo";
	}

	@GetMapping(value = "/todo/edit/{id}")
	public String editToDoForm(@PathVariable Long id, Model model) {
		ToDoDTO toDoDTO = new ToDoDTO();
		model.addAttribute("todo", toDoService.findOneById(id));
		return "edit_todo";
	}

	@GetMapping(value = "/register")
	public String registerUser(Model model) {
		UserDTO userDTO = new UserDTO();
		model.addAttribute("user", userDTO);
		return "register";
	}
	
	@GetMapping(value = "/todo/delete/{id}")
	public String deleteToDo(@PathVariable("id") Long id) {
		toDoService.delete(new Long[] { id });
		return "redirect:/todo";
	}

	@GetMapping(value = "/todo/complete/{id}")
	public String completeToDo(@PathVariable("id") Long id) {
		ToDoDTO todo = toDoService.findOneById(id);
		todo.setId(id);
		todo.setStatus(1);
		todo.setCompletedDate(new Timestamp(System.currentTimeMillis()));
		toDoService.save(todo);
		return "redirect:/todo";
	}

	@PostMapping(value = "/todo")
	public String createToDo(@ModelAttribute("todo") ToDoDTO toDoDTO) {
		toDoService.save(toDoDTO);
		return "redirect:/todo";
	}

	@PostMapping(value = "/todo/{id}")
	public String updateToDo(@ModelAttribute("todo") ToDoDTO toDoDTO, @PathVariable("id") Long id) {
		toDoDTO.setId(id);
		toDoService.save(toDoDTO);
		return "redirect:/todo";
	}

	@PostMapping(value = "/register")
	public String createToDo(@ModelAttribute("user") UserDTO userDTO) {
		userDTO.setRole("USER");
		userService.save(userDTO);
		return "redirect:/todo";
	}
	
//	@PostMapping(value="/todo")
//	public ToDoDTO createToDo(@RequestBody ToDoDTO model) {
//		
//		return toDoService.save(model);
//	}

//	@PutMapping(value="/todo/{id}")
//	public ToDoDTO updateToDo(@RequestBody ToDoDTO model, @PathVariable("id") Long id) {
//		model.setId(id);
//		return toDoService.save(model);
//	}

//	@DeleteMapping(value="/todo")
//	public void deleteToDo(@RequestBody Long[] ids) {
//		toDoService.delete(ids);
//	}
}
