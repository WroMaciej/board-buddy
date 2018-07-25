package com.capgemini.jstk.boardbuddy.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.jstk.boardbuddy.dao.UserDao;
import com.capgemini.jstk.boardbuddy.dao.impl.mock.CommonDatabaseMock;
import com.capgemini.jstk.boardbuddy.dto.UserDto;
import com.capgemini.jstk.boardbuddy.dto.mapper.Mapper;
import com.capgemini.jstk.boardbuddy.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	private Mapper<User, UserDto> userMapper;

	private Collection<User> users;
	
	
	
	@Autowired
	public UserDaoImpl(CommonDatabaseMock commonDatabaseMock, Mapper<User, UserDto> userMapper) {
		this.userMapper = userMapper;
		users = commonDatabaseMock.getUsers();
	}

	@Override
	public Optional<UserDto> findById(Integer id) {
		return Optional.ofNullable(userMapper.toDto(users.stream().filter(user -> user.getId().equals(id)).findFirst().get()));
	}

	@Override
	public List<UserDto> findAllUsers() {
		List<UserDto> userDtos = new ArrayList<>();
		users.forEach(user -> userDtos.add(userMapper.toDto(user)));
		return userDtos;
	}


}
