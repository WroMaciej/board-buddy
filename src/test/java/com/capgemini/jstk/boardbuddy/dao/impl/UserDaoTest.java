package com.capgemini.jstk.boardbuddy.dao.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//import static org.hamcrest.CoreMatchers.is;


import com.capgemini.jstk.boardbuddy.dao.UserDaoFacade;
import com.capgemini.jstk.boardbuddy.dto.UserDto;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

	
	@Autowired
	private UserDaoFacade userDaoFacade;
	
	@Before
    public void setUp() throws Exception {
        //userDao = new UserDaoImpl(commonDatabaseMock, userMapper);
    }

	@Test
	public void testFindById() {
		// when
		UserDto userDto = userDaoFacade.findById(1).get();
		// then
		assertEquals("John", userDto.getFirstName());	
	} 

	@Test
	public void testFindAllUsers() {
		//given
		int usersSize = 6;
		//when
		int foundSize = userDaoFacade.findAllUsers().size();

		//then
		assertEquals(usersSize, foundSize);
	}
}
