package com.capgemini.jstk.boardbuddy.dao;

import java.util.Optional;

import com.capgemini.jstk.boardbuddy.dto.ChallengeResultDto;

public interface ChallengeResultDaoFacade {
	
	public Optional<ChallengeResultDto> findById(Integer id);

}
