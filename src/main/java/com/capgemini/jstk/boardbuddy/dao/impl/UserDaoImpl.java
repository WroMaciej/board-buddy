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
import com.capgemini.jstk.boardbuddy.validation.exceptions.NoSuchElementInDatabase;

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

	@Override
	public void updateProfile(Integer userId, UserDto updatedUserDto) {
		try {
			User userBO = users.stream().filter(user -> user.getId().equals(userId)).findFirst().get();
			userBO.setEmail(updatedUserDto.getEmail());
			userBO.setFirstName(updatedUserDto.getFirstName());
			userBO.setLastName(updatedUserDto.getLastName());
			userBO.setLifeMotto(updatedUserDto.getLifeMotto());
		} catch (NullPointerException e) {
			throw new NoSuchElementInDatabase("User to be updated does not exist! User ID: " + userId);
		}		
	}


}
