package com.capgemini.jstk.boardbuddy.dao;

import java.util.Optional;

import com.capgemini.jstk.boardbuddy.dto.ChallengeResultDto;

public interface ChallengeResultDao {
	
	public Optional<ChallengeResultDto> findById(Integer id);

}
