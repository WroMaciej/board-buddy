package com.capgemini.jstk.boardbuddy.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.jstk.boardbuddy.dao.UserDaoFacade;
import com.capgemini.jstk.boardbuddy.dto.BoardgameDto;
import com.capgemini.jstk.boardbuddy.dto.ChallengeResultDto;
import com.capgemini.jstk.boardbuddy.dto.LevelDto;
import com.capgemini.jstk.boardbuddy.dto.StandbyPeriodDto;
import com.capgemini.jstk.boardbuddy.dto.UserDto;
import com.capgemini.jstk.boardbuddy.validation.exceptions.IllegalOperationException;
import com.capgemini.jstk.boardbuddy.validation.exceptions.NoSuchElementInDatabaseException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	
	
	@Autowired
	private UserServiceFacade userService;
	
	
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
		int rankPositionOfId1User = 4;
		//when
		int positionFound = userService.findRankPosition(userDtoId1);
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
	
	@Test
	public void testUserProfileInfo() {
		//given on setup
		//when
		UserDto profileData = userService.findUserProfileInfo(userDtoId1);
		//then
		assertEquals("John", profileData.getFirstName());
		assertEquals("Trabolta", profileData.getLastName());
		assertTrue(profileData.getScore() == null);
	}
	
	@Test
	public void testUserStatistics() {
		//given on setup
		//when
		UserDto statistics = userService.findUserStatistics(userDtoId1);
		//then
		assertEquals(4, statistics.getLevelValue().intValue());
		assertTrue(statistics.getEmail() == null);
	}
	
	@Test
	public void testShowUserHistory() {
		//given on setup
		//when
		Collection<ChallengeResultDto> history = userService.findUserChallenges(userDtoId1);
		//then
		assertEquals(4, history.size());
	}
	
	@Test
	public void testFindCommonStandbyPeriods() {
		//given user dtos on setup
		//when
		Collection<StandbyPeriodDto> commonPeriods = userService.findAllCommonPeriods(userDtoId1);		
		//then
		assertFalse(commonPeriods.isEmpty());
		assertFalse(userService.isCommonPeriodForUsers(userDtoId1, userDtoId3));
		assertTrue(userService.isCommonPeriodForUsers(userDtoId1, userDtoId5));		
	}
	
	@Test
	public void testUpdateProfile() throws IllegalOperationException{
		//given
		UserDto newUserProfile = new UserDto(null);
		newUserProfile.setEmail("new@domain.com");
		newUserProfile.setFirstName("Tom");
		//when
		userService.updateProfile(1, newUserProfile);
		UserDto updatedUser = userDaoFacade.findById(1).get();
		//then
		assertEquals("Tom", updatedUser.getFirstName());
		assertEquals("new@domain.com", updatedUser.getEmail());
		assertEquals(null, updatedUser.getLastName());
		
		//clean up
		newUserProfile.setEmail("johnny@domain.com");
		newUserProfile.setFirstName("John");
		newUserProfile.setLastName("Trabolta");
		newUserProfile.setLifeMotto("Lets dance!");
		userService.updateProfile(1, newUserProfile);
		
	}
	
	@Test
	public void testUpdateProfileWhichNotExist() throws IllegalOperationException{
		//given
		UserDto newUserProfile = new UserDto(null);
		newUserProfile.setEmail("new@domain.com");
		newUserProfile.setFirstName("Tom");
		boolean thrownException = false;
		//when
		
		try {
			userService.updateProfile(99, newUserProfile);
		} catch (NoSuchElementInDatabaseException e) {
			thrownException = true;
		}
		
		UserDto updatedUser = userDaoFacade.findById(1).get();
		//then
		assertTrue(thrownException);
		assertEquals("John", updatedUser.getFirstName());
		assertEquals("Trabolta", updatedUser.getLastName());
	}
	
	
	

}
