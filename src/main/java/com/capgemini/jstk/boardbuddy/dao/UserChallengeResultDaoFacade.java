package com.capgemini.jstk.boardbuddy.dao;

import java.util.Collection;

import com.capgemini.jstk.boardbuddy.dto.ChallengeResultDto;
import com.capgemini.jstk.boardbuddy.dto.UserDto;

public interface UserChallengeResultDaoFacade {

	public Collection<ChallengeResultDto> findUserChallenges(UserDto userDto);

}
