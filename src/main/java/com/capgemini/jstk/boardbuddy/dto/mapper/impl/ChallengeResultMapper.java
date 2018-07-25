package com.capgemini.jstk.boardbuddy.dto.mapper.impl;

import org.springframework.stereotype.Component;

import com.capgemini.jstk.boardbuddy.dto.ChallengeResultDto;
import com.capgemini.jstk.boardbuddy.dto.mapper.Mapper;
import com.capgemini.jstk.boardbuddy.entity.ChallengeResult;

@Component
public class ChallengeResultMapper implements Mapper<ChallengeResult, ChallengeResultDto> {

	@Override
	public ChallengeResultDto toDto(ChallengeResult entity) {
		final ChallengeResultDto challengeResultDto = new ChallengeResultDto();
		challengeResultDto.setId(entity.getId());
		challengeResultDto.setBoardgameId(entity.getBoardgameId());
		challengeResultDto.setDateOfStart(entity.getDateOfStart());
		challengeResultDto.setDateOfEnd(entity.getDateOfEnd());
		return challengeResultDto;
	}

	@Override
	public ChallengeResult toEntity(ChallengeResultDto dto) {
		return null;
	}

	
}
