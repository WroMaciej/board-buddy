package com.capgemini.jstk.boardbuddy.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.capgemini.jstk.boardbuddy.dao.UserDao;
import com.capgemini.jstk.boardbuddy.dto.UserDto;
import com.capgemini.jstk.boardbuddy.dto.mapper.Mapper;
import com.capgemini.jstk.boardbuddy.dto.mapper.impl.UserMapper;
import com.capgemini.jstk.boardbuddy.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	private static List<User> users;
	
	private Mapper<User, UserDto> userMapper;

	

	public UserDaoImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public Optional<UserDto> findById(Integer id) {
		return Optional.ofNullable(userMapper.toDto(users.stream().filter(user -> user.getId().equals(id)).findFirst().get()));
	}

	@Override
	public Optional<Integer> findRankPosition(UserDto userDto) {
		List<UserDto> sortedByScore = new ArrayList<>();
		users.forEach(user -> sortedByScore.add(userMapper.toDto(user)));
		sortedByScore.sort((user1, user2) -> user1.getScore() - user2.getScore());
		Integer rankPosition = sortedByScore.indexOf(userDto);
		return Optional.of(rankPosition);
	}


}
