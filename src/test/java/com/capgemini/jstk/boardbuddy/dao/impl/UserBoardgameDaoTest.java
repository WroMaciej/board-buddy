package com.capgemini.jstk.boardbuddy.dao.impl;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.jstk.boardbuddy.dao.User_BoardgameDaoFacade;
import com.capgemini.jstk.boardbuddy.dao.UserDaoFacade;
import com.capgemini.jstk.boardbuddy.dto.BoardgameDto;
import com.capgemini.jstk.boardbuddy.dto.UserDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserBoardgameDaoTest {
	
	@Autowired
	private User_BoardgameDaoFacade user_BoardgameDaoFacade;
	
	@Autowired
	UserDaoFacade userDaoFacade;
	
	UserDto userDtoId1;
	UserDto userDtoId3;
	UserDto userDtoId5;
	
	@Before
    public void setUp() throws Exception {
		userDtoId1 = userDaoFacade.findById(1).get();
		userDtoId3 = userDaoFacade.findById(3).get();
		userDtoId5 = userDaoFacade.findById(5).get();
    }
	
	@Test
	public void testFindBoardgamesByUser() {
		//given	
		//when
		Collection<BoardgameDto> boardgameDtos = user_BoardgameDaoFacade.findBoardgamesByUser(userDtoId5.getId());
		//then
		assertEquals(4, boardgameDtos.size());
	}

}
