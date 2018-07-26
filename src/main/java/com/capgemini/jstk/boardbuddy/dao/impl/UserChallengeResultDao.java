package com.capgemini.jstk.boardbuddy.dao.impl;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.jstk.boardbuddy.dao.ChallengeResultDaoFacade;
import com.capgemini.jstk.boardbuddy.dao.UserChallengeResultDaoFacade;
import com.capgemini.jstk.boardbuddy.dao.UserDaoFacade;
import com.capgemini.jstk.boardbuddy.dao.impl.mock.CommonDatabaseMock;
import com.capgemini.jstk.boardbuddy.dto.ChallengeResultDto;
import com.capgemini.jstk.boardbuddy.dto.UserDto;
import com.capgemini.jstk.boardbuddy.dto.User_ChallengeResult_Cto;
import com.capgemini.jstk.boardbuddy.dto.mapper.Mapper;
import com.capgemini.jstk.boardbuddy.entity.User_ChallengeResult_X;

@Repository
public class UserChallengeResultDao implements UserChallengeResultDaoFacade {

	private CommonDatabaseMock commonDatabaseMock;
	private ChallengeResultDaoFacade challengeResultDaoFacade;
	private Collection<User_ChallengeResult_X> user_ChallengeResult_Xs;
	
	@Autowired
	public UserChallengeResultDao(CommonDatabaseMock commonDatabaseMock,
			Mapper<User_ChallengeResult_X, User_ChallengeResult_Cto> user_ChallengeResult_XMapper, UserDaoFacade userDaoFacade,
			ChallengeResultDaoFacade challengeResultDaoFacade) {
		this.commonDatabaseMock = commonDatabaseMock;
		this.challengeResultDaoFacade = challengeResultDaoFacade;
		user_ChallengeResult_Xs = this.commonDatabaseMock.getUser_ChallengeResult_Xs();
	}



	@Override
	public Collection<ChallengeResultDto> findUserChallenges(UserDto userDto) {
		Stream<User_ChallengeResult_X> allWithSameUserId = user_ChallengeResult_Xs.stream()
				.filter(userChallengeResult -> userChallengeResult.getUserId().equals(userDto.getId()));
		Stream<ChallengeResultDto> mapped = allWithSameUserId.map(
				userChallengeResult -> challengeResultDaoFacade.findById(userChallengeResult.getChallengeResultId()).get() );
		return mapped.collect(Collectors.toList());
	}

}
