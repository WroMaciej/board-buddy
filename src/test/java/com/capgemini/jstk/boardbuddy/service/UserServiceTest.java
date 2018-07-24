package com.capgemini.jstk.boardbuddy.service;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.jstk.boardbuddy.dao.UserDao;
import com.capgemini.jstk.boardbuddy.dto.BoardgameDto;
import com.capgemini.jstk.boardbuddy.dto.LevelDto;
import com.capgemini.jstk.boardbuddy.dto.UserDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	
	
	@Autowired
	private UserService userService;
	
	
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
	public void testFindingUserLevel() {
		//given
		int levelOfId1User = 4;
		//when
		LevelDto level4 = userService.findLevel(userDtoId1);
		//then
		assertEquals(Integer.valueOf(levelOfId1User), level4.getLevelValue());
		assertEquals("Normal", level4.getName());
	}
	
	@Test
	public void testFindRankPosition() {
		//given
		Integer rankPositionOfId1User = 4;
		//when
		Integer positionFound = userService.findRankPosition(userDtoId1).get();
		//then
		assertEquals(rankPositionOfId1User, positionFound);
	}
	
	@Test
	public void testFindUserBoardgames() {
		//given
		Collection<BoardgameDto> boardgameDtos= userService.findUserBoardgames(userDtoId3);
		//when
		int gamesNumber = boardgameDtos.size();
		boolean hasDuopolyGame = boardgameDtos.stream().anyMatch(game -> game.getName().equals("Duopoly"));
		boolean hasEverybodyWantsMeGame = boardgameDtos.stream().anyMatch(game -> game.getName().equals("Everybody wants me!"));
		//then
		assertEquals(2, gamesNumber);
		assertEquals(true, hasDuopolyGame);
		assertEquals(true, hasEverybodyWantsMeGame);
		
		
	}
	
	

}
