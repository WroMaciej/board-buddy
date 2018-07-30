package com.capgemini.jstk.boardbuddy.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.jstk.boardbuddy.dto.UserDto;
import com.capgemini.jstk.boardbuddy.validation.exceptions.rest.UserNotFoundException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
	
	@Autowired
	UserController userController;
	
	@Test
	public void testGetUserById() {
		// given
		String firstName = "John";
		String lastName = "Trabolta";
		// when
		ResponseEntity<UserDto> response = userController.getUserById(1);
		//then
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(firstName, response.getBody().getFirstName());
		assertEquals(lastName, response.getBody().getLastName());
	}
	
	@Test
	public void testUserNotFound() {
		// given
		Integer userDoesntExist = Integer.valueOf(-1);
		boolean exceptionThrown = false;
		Exception exception = null;
		// when
		try {
			userController.getUserById(userDoesntExist);
		} catch (UserNotFoundException e) {
			exception = e;
			exceptionThrown = true;
		}
		//then
		assertEquals("User with given id not found. ID: -1", exception.getMessage());
		assertTrue(exceptionThrown);
	}
	
	

}
