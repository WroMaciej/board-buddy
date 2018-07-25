package com.capgemini.jstk.boardbuddy.dto.mapper.impl;

import org.springframework.stereotype.Component;

import com.capgemini.jstk.boardbuddy.dto.User_ChallengeResult_Cto;
import com.capgemini.jstk.boardbuddy.dto.mapper.Mapper;
import com.capgemini.jstk.boardbuddy.entity.User_ChallengeResult_X;

@Component
public class User_ChallengeResultMapper implements Mapper<User_ChallengeResult_X, User_ChallengeResult_Cto>{

	@Override
	public User_ChallengeResult_Cto toDto(User_ChallengeResult_X entity) {
		final User_ChallengeResult_Cto user_ChallengeResult_Cto = new User_ChallengeResult_Cto(entity.getId());
		user_ChallengeResult_Cto.setChallengeResultId(entity.getChallengeResultId());
		user_ChallengeResult_Cto.setUserId(entity.getUserId());
		user_ChallengeResult_Cto.setPlaceTaken(entity.getPlaceTaken());
		return user_ChallengeResult_Cto;
	}

	@Override
	public User_ChallengeResult_X toEntity(User_ChallengeResult_Cto dto) {
		return null;
	}

}
