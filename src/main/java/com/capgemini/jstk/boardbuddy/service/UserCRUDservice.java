package com.capgemini.jstk.boardbuddy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.jstk.boardbuddy.dao.UserDao;
import com.capgemini.jstk.boardbuddy.dto.UserDto;

@Service
public class UserCRUDservice {
	
	private UserDao userDao;
	
	@Autowired
	public UserCRUDservice(UserDao userDao) {
		this.userDao = userDao;
	}



	public void updateProfile (Integer userId, UserDto updatedUserDto) {
		userDao.updateProfile(userId, updatedUserDto);
	}

}
