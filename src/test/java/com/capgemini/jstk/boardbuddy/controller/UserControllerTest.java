package com.capgemini.jstk.boardbuddy.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.jstk.boardbuddy.dto.UserDto;


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
	
	

}
