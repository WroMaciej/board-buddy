package com.capgemini.jstk.boardbuddy.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.jstk.boardbuddy.dto.UserDto;
import com.capgemini.jstk.boardbuddy.service.UserServiceFacade;

@RestController
public class UserController {
	
	@Autowired
	private UserServiceFacade userService;

	@GetMapping("/users")
	public @ResponseBody ResponseEntity<Collection<UserDto>> getAllUsers(){
		return ResponseEntity.ok().body(userService.findAllUsers());
	}
	
	@GetMapping("/user/{id}")
	public @ResponseBody ResponseEntity<UserDto> getUserById(@PathVariable("id") Integer userId){
		Optional<UserDto> userDto = userService.findUserById(userId);
		if (!userDto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(userDto.get());
	}
}
