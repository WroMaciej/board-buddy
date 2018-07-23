package com.capgemini.jstk.boardbuddy.dto.mapper.impl;

import org.springframework.boot.autoconfigure.sendgrid.SendGridAutoConfiguration;
import org.springframework.stereotype.Component;

import com.capgemini.jstk.boardbuddy.dto.UserChallengeResultDto;
import com.capgemini.jstk.boardbuddy.dto.mapper.Mapper;
import com.capgemini.jstk.boardbuddy.entity.UserChallengeResult;

@Component
public class UserChallengeResultMapper implements Mapper<UserChallengeResult, UserChallengeResultDto>{

	@Override
	public UserChallengeResultDto toDto(UserChallengeResult entity) {
		final UserChallengeResultDto userChallengeResultDto = new UserChallengeResultDto();
		userChallengeResultDto.setId(entity.getId());
		userChallengeResultDto.setChallengeResultId(entity.getChallengeResultId());
		userChallengeResultDto.setUserId(entity.getUserId());
		userChallengeResultDto.setPlaceTaken(entity.getPlaceTaken());
		return userChallengeResultDto;
	}

	@Override
	public UserChallengeResult toEntity(UserChallengeResultDto dto) {
		return null;
	}

}
