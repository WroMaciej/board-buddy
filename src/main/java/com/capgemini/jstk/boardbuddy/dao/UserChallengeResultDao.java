package com.capgemini.jstk.boardbuddy.dao;

import java.util.Collection;

import com.capgemini.jstk.boardbuddy.dto.ChallengeResultDto;
import com.capgemini.jstk.boardbuddy.dto.UserDto;

public interface UserChallengeResultDao {

	public Collection<ChallengeResultDto> findUserChallenges(UserDto userDto);

}
