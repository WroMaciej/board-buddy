package com.capgemini.jstk.boardbuddy.dao.impl;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.jstk.boardbuddy.dao.User_BoardgameDao;
import com.capgemini.jstk.boardbuddy.dao.UserDao;
import com.capgemini.jstk.boardbuddy.dto.BoardgameDto;
import com.capgemini.jstk.boardbuddy.dto.UserDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserBoardgameDaoImplTest {
	
	@Autowired
	private User_BoardgameDao user_BoardgameDao;
	
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
	public void testFindBoardgamesByUser() {
		//given	
		//when
		Collection<BoardgameDto> boardgameDtos = user_BoardgameDao.findBoardgamesByUser(userDtoId5.getId());
		//then
		assertEquals(4, boardgameDtos.size());
	}

}
