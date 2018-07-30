package com.capgemini.jstk.boardbuddy.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.jstk.boardbuddy.dao.LevelDaoFacade;
import com.capgemini.jstk.boardbuddy.dao.StandbyPeriodDaoFacade;
import com.capgemini.jstk.boardbuddy.dao.UserChallengeResultDaoFacade;
import com.capgemini.jstk.boardbuddy.dao.UserDaoFacade;
import com.capgemini.jstk.boardbuddy.dao.User_BoardgameDaoFacade;
import com.capgemini.jstk.boardbuddy.dto.BoardgameDto;
import com.capgemini.jstk.boardbuddy.dto.ChallengeResultDto;
import com.capgemini.jstk.boardbuddy.dto.LevelDto;
import com.capgemini.jstk.boardbuddy.dto.StandbyPeriodDto;
import com.capgemini.jstk.boardbuddy.dto.UserDto;
import com.capgemini.jstk.boardbuddy.service.StandbyPeriodServiceFacade;
import com.capgemini.jstk.boardbuddy.service.UserServiceFacade;
import com.capgemini.jstk.boardbuddy.validation.ValidatorFacade;
import com.capgemini.jstk.boardbuddy.validation.exceptions.IllegalOperationException;
import com.capgemini.jstk.boardbuddy.validation.exceptions.NoSuchElementInDatabaseException;
import com.capgemini.jstk.boardbuddy.validation.exceptions.rest.UserNotFoundException;

@Service
public class UserService implements UserServiceFacade {

	private ValidatorFacade<UserDto> userValidatorFacade;
	private UserDaoFacade userDaoFacade;
	private LevelDaoFacade levelDaoFacade;
	private User_BoardgameDaoFacade user_BoardgameDaoFacade;
	private UserChallengeResultDaoFacade userChallengeResultDaoFacade;
	private StandbyPeriodDaoFacade standbyPeriodDaoFacade;
	private StandbyPeriodServiceFacade standbyPeriodService;

	@Autowired
	public UserService(UserDaoFacade userDaoFacade, LevelDaoFacade levelDaoFacade, User_BoardgameDaoFacade user_BoardgameDaoFacade,
			UserChallengeResultDaoFacade userChallengeResultDaoFacade, StandbyPeriodDaoFacade standbyPerdiodDao,
			StandbyPeriodServiceFacade standbyPeriodService, ValidatorFacade<UserDto> userValidator) {
		this.userValidatorFacade = userValidator;
		this.userDaoFacade = userDaoFacade;
		this.levelDaoFacade = levelDaoFacade;
		this.user_BoardgameDaoFacade = user_BoardgameDaoFacade;
		this.userChallengeResultDaoFacade = userChallengeResultDaoFacade;
		this.standbyPeriodDaoFacade = standbyPerdiodDao;
		this.standbyPeriodService = standbyPeriodService;
	}
	
	
	@Override
	public Optional<UserDto> findUserById(Integer userId) {
	Optional<UserDto> userDto = userDaoFacade.findById(userId);
	if (!userDto.isPresent()) {
		throw new UserNotFoundException("User with given id not found. ID: " + userId);
	}
		return userDto;
	}

	@Override
	public Collection<UserDto> findAllUsers() {
		return userDaoFacade.findAllUsers();
	}
	

	@Override
	public LevelDto findLevel(UserDto userDto) {
		Optional<LevelDto> userLevel = levelDaoFacade.findByScore(userDto.getScore());
		if (!userLevel.isPresent()) {
			throw new NoSuchElementInDatabaseException("Level for given user not found.");
		}
		return userLevel.get();
	}

	@Override
	public UserDto findLevelAndGetUpdatedDto(UserDto userDto) {
		LevelDto userLevel = findLevel(userDto);
		userDto.setLevelValue(userLevel.getLevelValue());
		return userDto;
	}

	@Override
	public Integer findRankPosition(UserDto userDto) {
		List<UserDto> sortedByScore = userDaoFacade.findAllUsers();
		sortedByScore.sort((user1, user2) -> user1.getScore() - user2.getScore());
		int rankPosition = sortedByScore.indexOf(userDto) + 1;
		if (rankPosition == -1) {
			throw new NoSuchElementException(
					"There is no such user in database. User email: " + userDto.getEmail());
		}
		return rankPosition;
	}

	@Override
	public Collection<BoardgameDto> findUserBoardgames(UserDto userDto) {
		return user_BoardgameDaoFacade.findBoardgamesByUser(userDto.getId());
	}

	@Override
	public UserDto findUserProfileInfo(UserDto userDto) {
		UserDto userProfileData = new UserDto(userDto.getId());
		userProfileData.setEmail(userDto.getEmail());
		userProfileData.setFirstName(userDto.getFirstName());
		userProfileData.setLastName(userDto.getLastName());
		userProfileData.setLifeMotto(userDto.getLifeMotto());

		return userProfileData;
	}

	@Override
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

	@Override
	public Collection<ChallengeResultDto> findUserChallenges(UserDto userDto) {
		return userChallengeResultDaoFacade.findUserChallenges(userDto);
	}

	@Override
	public Collection<StandbyPeriodDto> findAllCommonPeriods(Integer userId) {
		findUserById(userId);
		Collection<Optional<StandbyPeriodDto>> rawCommonPeriods = new ArrayList<>();
		Collection<StandbyPeriodDto> commonPeriods = new ArrayList<>();
		Collection<StandbyPeriodDto> userPeriods = standbyPeriodDaoFacade.findByUser(userId);
		Collection<StandbyPeriodDto> allPeriods = standbyPeriodDaoFacade.findAll();

		for (StandbyPeriodDto userPeriod : userPeriods) {
			Predicate<StandbyPeriodDto> isActive = period -> period.isActive();
			Predicate<StandbyPeriodDto> otherUser = anyPeriod -> !anyPeriod.getUserId().equals(userId);
			allPeriods.stream().filter(otherUser.and(isActive))
					.forEach(anyPeriod -> rawCommonPeriods
							.add(standbyPeriodService.commonPeriod(userPeriod, anyPeriod)));
		}
		commonPeriods = rawCommonPeriods.stream().filter(Optional<StandbyPeriodDto>::isPresent)
				.map(Optional::get).collect(Collectors.toList());

		return commonPeriods;
	}

	@Override
	public Collection<StandbyPeriodDto> findCommonPeriodsWithAnotherUser(Integer userId1, Integer userId2) {
		findUserById(userId1);
		findUserById(userId2);
		return findAllCommonPeriods(userId1).stream()
				.filter(period -> period.getUserId().equals(userId2))
				.collect(Collectors.toSet());
	}

	@Override
	public boolean isCommonPeriodForUsers(Integer userId1, Integer userId2) {
		return !findCommonPeriodsWithAnotherUser(userId1, userId2).isEmpty();
	}

	@Override
	public void updateProfile(Integer userId, UserDto updatedUserDto)
			throws IllegalOperationException {
		userValidatorFacade.validate(updatedUserDto);
		userDaoFacade.updateProfile(userId, updatedUserDto);
	}

	@Override
	public Map<UserDto, String> deleteStandbyPeriod(Integer userId, Integer deletingPeriodId,
			String comment) throws IllegalAccessException {
		Map<UserDto, String> userMessageMap = new HashMap<>();
		Collection<StandbyPeriodDto> commonStandbys = findAllCommonPeriods(userId);
		commonStandbys.stream()
				.forEach(period -> userMessageMap.put(userDaoFacade.findById(period.getUserId()).get(), comment));
		standbyPeriodDaoFacade.deleteStandbyPeriod(userId, deletingPeriodId);
		return userMessageMap;
	}

	

}