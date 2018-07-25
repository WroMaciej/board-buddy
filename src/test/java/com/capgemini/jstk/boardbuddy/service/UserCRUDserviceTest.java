package com.capgemini.jstk.boardbuddy.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.jstk.boardbuddy.dao.UserDao;
import com.capgemini.jstk.boardbuddy.dto.UserDto;
import com.capgemini.jstk.boardbuddy.validation.exceptions.NoSuchElementInDatabaseException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserCRUDserviceTest {
	
	@Autowired
	private UserCRUDservice userCRUDservice;
	
	
	@Autowired
	UserDao userDao;
	
	UserDto userDtoId1;
	UserDto userDtoId3;
	UserDto userDtoId5;
	
	@Before
    public void setUp() throws Exception {
		userDtoId1 = userDao.findById(1).get();
		userDtoId3 = userDao.findById(3).get();
		userDtoId5 = userDao.findById(5).get();
    }
	
	@Test
	public void testUpdateProfile(){
		//given
		UserDto newUserProfile = new UserDto(null);
		newUserProfile.setEmail("new@domain.com");
		newUserProfile.setFirstName("Tom");
		//when
		userCRUDservice.updateProfile(1, newUserProfile);
		UserDto updatedUser = userDao.findById(1).get();
		//then
		assertEquals("Tom", updatedUser.getFirstName());
		assertEquals("new@domain.com", updatedUser.getEmail());
		assertEquals(null, updatedUser.getLastName());
	}
	
	@Test
	public void testUpdateProfileWhichNotExist(){
		//given
		UserDto newUserProfile = new UserDto(null);
		newUserProfile.setEmail("new@domain.com");
		newUserProfile.setFirstName("Tom");
		boolean thrownException = false;
		//when
		
		try {
			userCRUDservice.updateProfile(99, newUserProfile);
		} catch (NoSuchElementInDatabaseException e) {
			thrownException = true;
		}
		
		UserDto updatedUser = userDao.findById(1).get();
		//then
		assertTrue(thrownException);
		assertEquals("John", updatedUser.getFirstName());
		assertEquals("Trabolta", updatedUser.getLastName());
	}
	

}
