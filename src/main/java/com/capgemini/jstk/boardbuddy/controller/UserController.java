package com.capgemini.jstk.boardbuddy.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.jstk.boardbuddy.dto.UserDto;
import com.capgemini.jstk.boardbuddy.service.UserServiceFacade;
import com.capgemini.jstk.boardbuddy.validation.exceptions.IllegalOperationException;

@RestController
public class UserController {

	@Autowired
	private UserServiceFacade userService;

//	@ExceptionHandler(UserNotFoundException.class)
//	public ResponseEntity<UserErrorResponse> userNotFoundExceptionHandler(UserNotFoundException exception){
//		UserErrorResponse response = new UserErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage());
//		return new ResponseEntity<UserErrorResponse>(response, HttpStatus.NOT_FOUND);
//	}

	@GetMapping("/users")
	public @ResponseBody ResponseEntity<Collection<UserDto>> getAllUsers() {
		return ResponseEntity.ok().body(userService.findAllUsers());
	}

	@GetMapping("/user/{id}")
	public @ResponseBody ResponseEntity<UserDto> getUserById(@PathVariable("id") Integer userId) {
		Optional<UserDto> userDto = userService.findUserById(userId);
		return ResponseEntity.ok().body(userDto.get());
	}

	@PutMapping("/user/{email}")
	public @ResponseBody ResponseEntity<UserDto> updateUserByEmail(@PathVariable String email,
			@RequestBody UserDto userDto) throws IllegalOperationException {
		Integer userId = userService.findByEmail(email).get().getId();
		userService.updateProfile(userId, userDto);
		return ResponseEntity.ok().body(userService.findUserById(userId).get());
	}
}
