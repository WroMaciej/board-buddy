package com.capgemini.jstk.boardbuddy.dao.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.jstk.boardbuddy.dao.LevelDao;
import com.capgemini.jstk.boardbuddy.dao.impl.mock.CommonDatabaseMock;
import com.capgemini.jstk.boardbuddy.dto.LevelDto;
import com.capgemini.jstk.boardbuddy.dto.mapper.impl.UserMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LevelDaoImplTest {
	
	@Autowired
	private LevelDao levelDao;
	
	@Autowired
	private CommonDatabaseMock commonDatabaseMock;
	
	@Autowired
	private UserMapper userMapper;
	
	@Before
    public void setUp() throws Exception {
        //userDao = new UserDaoImpl(commonDatabaseMock, userMapper);
    }

	@Test
	public void testFindById() {
		// when
		LevelDto levelDto = levelDao.findById(3).get();
		// then
		assertEquals("John", userDto.getFirstName());	
	}

}
