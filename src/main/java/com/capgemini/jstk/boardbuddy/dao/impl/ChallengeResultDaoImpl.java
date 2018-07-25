package com.capgemini.jstk.boardbuddy.dao.impl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.jstk.boardbuddy.dao.ChallengeResultDao;
import com.capgemini.jstk.boardbuddy.dao.impl.mock.CommonDatabaseMock;
import com.capgemini.jstk.boardbuddy.dto.ChallengeResultDto;
import com.capgemini.jstk.boardbuddy.dto.mapper.Mapper;
import com.capgemini.jstk.boardbuddy.entity.ChallengeResult;

@Repository
public class ChallengeResultDaoImpl implements ChallengeResultDao {

	
	private Mapper<ChallengeResult, ChallengeResultDto> challengeResultMapper;
	
	private Collection<ChallengeResult> challengeResults;
	
	
	@Autowired
	public ChallengeResultDaoImpl(CommonDatabaseMock commonDatabaseMock,
			Mapper<ChallengeResult, ChallengeResultDto> challengeResultMapper) {
		this.challengeResultMapper = challengeResultMapper;
		challengeResults = commonDatabaseMock.getChallengeResults();
	}



	@Override
	public Optional<ChallengeResultDto> findById(Integer id) {
		return Optional.ofNullable(
				challengeResultMapper.toDto(
						challengeResults.stream().filter(challengeResults -> challengeResults.getId().equals(id)).findFirst().get() ) );
	}
}
