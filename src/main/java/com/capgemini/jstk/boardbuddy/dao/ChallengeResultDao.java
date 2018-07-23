package com.capgemini.jstk.boardbuddy.dao;

import java.util.Optional;

import com.capgemini.jstk.boardbuddy.entity.ChallengeResult;

public interface ChallengeResultDao {
	
	public Optional<ChallengeResult> findById(Integer id);

}
