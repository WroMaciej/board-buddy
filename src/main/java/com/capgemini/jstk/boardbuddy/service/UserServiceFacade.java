package com.capgemini.jstk.boardbuddy.service;

import java.util.Collection;

import com.capgemini.jstk.boardbuddy.dto.BoardgameDto;
import com.capgemini.jstk.boardbuddy.dto.ChallengeResultDto;
import com.capgemini.jstk.boardbuddy.dto.LevelDto;
import com.capgemini.jstk.boardbuddy.dto.StandbyPeriodDto;
import com.capgemini.jstk.boardbuddy.dto.UserDto;
import com.capgemini.jstk.boardbuddy.validation.exceptions.IllegalOperationException;

public interface UserServiceFacade {

	LevelDto findLevel(UserDto userDto);

	UserDto findLevelAndGetUpdatedDto(UserDto userDto);

	Integer findRankPosition(UserDto userDto);

	Collection<BoardgameDto> findUserBoardgames(UserDto userDto);

	UserDto findUserProfileInfo(UserDto userDto);

	UserDto findUserStatistics(UserDto userDto);

	Collection<ChallengeResultDto> findUserChallenges(UserDto userDto);

	Collection<StandbyPeriodDto> findAllCommonPeriods(UserDto userDto);

	Collection<StandbyPeriodDto> findCommonPeriodsWithAnotherUser(UserDto userDto1, UserDto userDto2);

	boolean isCommonPeriodForUsers(UserDto userDto1, UserDto userDto2);

	void updateProfile(Integer userId, UserDto updatedUserDto) throws IllegalOperationException;

}

