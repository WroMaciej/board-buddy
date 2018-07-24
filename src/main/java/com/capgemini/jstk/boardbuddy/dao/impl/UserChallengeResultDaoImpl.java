package com.capgemini.jstk.boardbuddy.dao.impl;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.jstk.boardbuddy.dao.ChallengeResultDao;
import com.capgemini.jstk.boardbuddy.dao.UserChallengeResultDao;
import com.capgemini.jstk.boardbuddy.dao.UserDao;
import com.capgemini.jstk.boardbuddy.dao.impl.mock.CommonDatabaseMock;
import com.capgemini.jstk.boardbuddy.dto.ChallengeResultDto;
import com.capgemini.jstk.boardbuddy.dto.UserChallengeResultDto;
import com.capgemini.jstk.boardbuddy.dto.UserDto;
import com.capgemini.jstk.boardbuddy.dto.mapper.Mapper;
import com.capgemini.jstk.boardbuddy.entity.User;
import com.capgemini.jstk.boardbuddy.entity.UserChallengeResult;

@Repository
public class UserChallengeResultDaoImpl implements UserChallengeResultDao {

	private CommonDatabaseMock commonDatabaseMock;
	private Mapper<UserChallengeResult, UserChallengeResultDto> userChallengeResultMapper;
	private UserDao userDao;
	private ChallengeResultDao challengeResultDao;
	private Collection<UserChallengeResult> userChallengeResults;
	
	@Autowired
	public UserChallengeResultDaoImpl(CommonDatabaseMock commonDatabaseMock,
			Mapper<UserChallengeResult, UserChallengeResultDto> userChallengeResultMapper, UserDao userDao,
			ChallengeResultDao challengeResultDao) {
		this.commonDatabaseMock = commonDatabaseMock;
		this.userChallengeResultMapper = userChallengeResultMapper;
		this.userDao = userDao;
		this.challengeResultDao = challengeResultDao;
		this.userChallengeResults = this.commonDatabaseMock.getUserChallengeResults();
	}



	@Override
	public Collection<ChallengeResultDto> findUserChallenges(UserDto userDto) {
		Stream<UserChallengeResult> allWithSameUserId = userChallengeResults.stream()
				.filter(userChallengeResult -> userChallengeResult.getUserId().equals(userDto.getId()));
		Stream<ChallengeResultDto> mapped = allWithSameUserId.map(
				userChallengeResult -> challengeResultDao.findById(userChallengeResult.getChallengeResultId()).get() );
		return mapped.collect(Collectors.toList());
	}

}
