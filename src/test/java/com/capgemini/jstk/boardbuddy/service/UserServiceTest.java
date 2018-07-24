package com.capgemini.jstk.boardbuddy.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.jstk.boardbuddy.dao.UserDao;
import com.capgemini.jstk.boardbuddy.dao.impl.mock.CommonDatabaseMock;
import com.capgemini.jstk.boardbuddy.dto.UserDto;
import com.capgemini.jstk.boardbuddy.dto.mapper.impl.UserMapper;
import com.capgemini.jstk.boardbuddy.entity.Level;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CommonDatabaseMock commonDatabaseMock;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	private UserMapper userMapper;
	
	UserDto userDtoId1;
	UserDto userDtoId3;
	UserDto userDtoId5;
	
	@Before
    public void setUp() throws Exception {
		UserDto userDto1 = userDao.findById(1).get();
		UserDto userDto3 = userDao.findById(3).get();
		UserDto userDto5 = userDao.findById(5).get();
    }
	
	@Test
	public void testFindingUserLevel() {
		//given
		
		//when
		Level level4 = userService.findLevel(userDtoId1);
		//then
		assertEquals(Integer.valueOf(4), level4.getLevelValue());
		
		
		
	}
	
	

}
