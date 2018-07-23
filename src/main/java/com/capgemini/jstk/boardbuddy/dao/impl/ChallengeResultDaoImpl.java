package com.capgemini.jstk.boardbuddy.dao.impl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.capgemini.jstk.boardbuddy.dao.ChallengeResultDao;
import com.capgemini.jstk.boardbuddy.entity.Boardgame;
import com.capgemini.jstk.boardbuddy.entity.ChallengeResult;

@Repository
public class ChallengeResultDaoImpl implements ChallengeResultDao {

private static Collection<ChallengeResult> challengeResults;
	
	@Override
	public Optional<ChallengeResult> findById(Integer id) {
		return challengeResults.stream().filter(challengeResults -> challengeResults.getId().equals(id)).findFirst();
	}
}
