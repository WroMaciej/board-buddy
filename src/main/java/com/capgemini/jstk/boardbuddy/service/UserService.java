package com.capgemini.jstk.boardbuddy.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.jstk.boardbuddy.dao.LevelDao;
import com.capgemini.jstk.boardbuddy.dao.StandbyPeriodDao;
import com.capgemini.jstk.boardbuddy.dao.UserChallengeResultDao;
import com.capgemini.jstk.boardbuddy.dao.UserDao;
import com.capgemini.jstk.boardbuddy.dao.User_BoardgameDao;
import com.capgemini.jstk.boardbuddy.dto.BoardgameDto;
import com.capgemini.jstk.boardbuddy.dto.ChallengeResultDto;
import com.capgemini.jstk.boardbuddy.dto.LevelDto;
import com.capgemini.jstk.boardbuddy.dto.StandbyPeriodDto;
import com.capgemini.jstk.boardbuddy.dto.UserDto;
import com.capgemini.jstk.boardbuddy.validation.Validator;
import com.capgemini.jstk.boardbuddy.validation.exceptions.IllegalOperationException;
import com.capgemini.jstk.boardbuddy.validation.exceptions.NoSuchElementInDatabaseException;

@Service
public class UserService {

	private Validator<UserDto> userValidator;
	private UserDao userDao;
	private LevelDao levelDao;
	private User_BoardgameDao user_BoardgameDao;
	private UserChallengeResultDao userChallengeResultDao;
	private StandbyPeriodDao standbyPerdiodDao;
	private StandbyPeriodService standbyPeriodService;

	

	@Autowired
	public UserService(UserDao userDao, LevelDao levelDao, User_BoardgameDao user_BoardgameDao,
			UserChallengeResultDao userChallengeResultDao, StandbyPeriodDao standbyPerdiodDao,
			StandbyPeriodService standbyPeriodService, Validator<UserDto> userValidator) {
		this.userValidator = userValidator;
		this.userDao = userDao;
		this.levelDao = levelDao;
		this.user_BoardgameDao = user_BoardgameDao;
		this.userChallengeResultDao = userChallengeResultDao;
		this.standbyPerdiodDao = standbyPerdiodDao;
		this.standbyPeriodService = standbyPeriodService;
	}

	public LevelDto findLevel(UserDto userDto) {
		Optional<LevelDto> userLevel = levelDao.findByScore(userDto.getScore());
		if (!userLevel.isPresent()) {
			throw new NoSuchElementInDatabaseException("Level for given user not found.");
		}
		return userLevel.get();
	}


	public UserDto findLevelAndGetUpdatedDto(UserDto userDto) {
		LevelDto userLevel = findLevel(userDto);
		userDto.setLevelValue(userLevel.getLevelValue());
		return userDto;
	}
	
	public Integer findRankPosition(UserDto userDto) {
		List<UserDto> sortedByScore = userDao.findAllUsers();
		sortedByScore.sort((user1, user2) -> user1.getScore() - user2.getScore());
		int rankPosition = sortedByScore.indexOf(userDto) + 1;
		if (rankPosition == -1) {
			throw new NoSuchElementException("There is no such user in database. User email: " + userDto.getEmail());
		}
		return rankPosition;
	}
	
	public Collection<BoardgameDto> findUserBoardgames(UserDto userDto){
		return user_BoardgameDao.findBoardgamesByUser(userDto.getId());
	}
	
	public UserDto findUserProfileInfo(UserDto userDto) {
		UserDto userProfileData = new UserDto(userDto.getId());
		userProfileData.setEmail(userDto.getEmail());
		userProfileData.setFirstName(userDto.getFirstName());
		userProfileData.setLastName(userDto.getLastName());
		userProfileData.setLifeMotto(userDto.getLifeMotto());
		
		return userProfileData;
	}

	public UserDto findUserStatistics(UserDto userDto) {
		UserDto userStatistics = new UserDto(userDto.getId());
		userStatistics.setWins(userDto.getWins());
		userStatistics.setLosses(userDto.getLosses());
		userStatistics.setDraws(userDto.getDraws());
		userStatistics.setScore(userDto.getScore());
		userStatistics.setLevelValue(findLevel(userDto).getLevelValue());
		userStatistics.setRankPosition(findRankPosition(userDto));
		
		return userStatistics;
	}

	public Collection<ChallengeResultDto> findUserChallenges(UserDto userDto) {
		return userChallengeResultDao.findUserChallenges(userDto);
	}

	public Collection<StandbyPeriodDto> findAllCommonPeriods(UserDto userDto) {
		Collection<Optional<StandbyPeriodDto>> rawCommonPeriods = new ArrayList<>();
		Collection<StandbyPeriodDto> commonPeriods = new ArrayList<>();
		Collection<StandbyPeriodDto> userPeriods = standbyPerdiodDao.findByUser(userDto);
		Collection<StandbyPeriodDto> allPeriods = standbyPerdiodDao.findAll();
		
		for (StandbyPeriodDto userPeriod : userPeriods) {
			Predicate<StandbyPeriodDto> isActive = period -> period.isActive();
			Predicate<StandbyPeriodDto> otherUser = anyPeriod -> anyPeriod.getUserId() != userDto.getId();
			allPeriods.stream().filter(otherUser.and(isActive)).forEach(anyPeriod -> rawCommonPeriods.add(standbyPeriodService.commonPeriod(userPeriod, anyPeriod)) );
		}
		commonPeriods = rawCommonPeriods.stream().filter(Optional<StandbyPeriodDto>::isPresent).map(Optional::get).collect(Collectors.toList());
		
		return commonPeriods;
	}
	
	public Collection<StandbyPeriodDto> findCommonPeriodsWithAnotherUser(UserDto userDto1, UserDto userDto2){
		return findAllCommonPeriods(userDto1).stream().filter(period -> period.getUserId().equals(userDto2.getId())).collect(Collectors.toSet());
	}
	
	public boolean isCommonPeriodForUsers(UserDto userDto1, UserDto userDto2) {
		return !findCommonPeriodsWithAnotherUser(userDto1, userDto2).isEmpty();
	}
	
	public void updateProfile (Integer userId, UserDto updatedUserDto) throws IllegalOperationException {
		userValidator.validate(updatedUserDto);
		userDao.updateProfile(userId, updatedUserDto);
	}
	
	

}