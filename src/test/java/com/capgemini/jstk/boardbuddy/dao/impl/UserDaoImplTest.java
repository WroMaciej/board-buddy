package com.capgemini.jstk.boardbuddy.dao.impl;

import static org.junit.Assert.assertThat;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.jstk.boardbuddy.dto.UserDto;

public class UserDaoImplTest {

	
	@Autowired
	private UserDaoImpl userDaoImpl;

	@Test
	public void testFindById() {
		// when
		UserDto userDto = userDaoImpl.findById(1).get();
		// then
		//assertThat(userDto.getFirstName(), is("John"));
		
	}
}
