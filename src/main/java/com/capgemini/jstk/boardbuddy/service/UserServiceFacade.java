package com.capgemini.jstk.boardbuddy.service;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import com.capgemini.jstk.boardbuddy.dto.BoardgameDto;
import com.capgemini.jstk.boardbuddy.dto.ChallengeResultDto;
import com.capgemini.jstk.boardbuddy.dto.LevelDto;
import com.capgemini.jstk.boardbuddy.dto.StandbyPeriodDto;
import com.capgemini.jstk.boardbuddy.dto.UserDto;
import com.capgemini.jstk.boardbuddy.validation.exceptions.IllegalOperationException;

public interface UserServiceFacade {

	Optional<UserDto> findUserById(Integer userId);
	
	Optional<UserDto> findByEmail(String email);
	
	Collection<UserDto> findAllUsers();
	
	LevelDto findLevel(UserDto userDto);

	UserDto findLevelAndGetUpdatedDto(UserDto userDto);

	Integer findRankPosition(UserDto userDto);

	Collection<BoardgameDto> findUserBoardgames(UserDto userDto);

	UserDto findUserProfileInfo(UserDto userDto);

	UserDto findUserStatistics(UserDto userDto);

	Collection<ChallengeResultDto> findUserChallenges(UserDto userDto);

	Collection<StandbyPeriodDto> findAllCommonPeriods(Integer userId);

	Collection<StandbyPeriodDto> findCommonPeriodsWithAnotherUser(Integer userId1, Integer userId2);

	boolean isCommonPeriodForUsers(Integer userId1, Integer userId2);

	void updateProfile(Integer userId, UserDto updatedUserDto) throws IllegalOperationException;

	Map<UserDto, String> deleteStandbyPeriod(Integer userId, Integer deletingPeriodId,
			String comment) throws IllegalAccessException;
	
	

}

