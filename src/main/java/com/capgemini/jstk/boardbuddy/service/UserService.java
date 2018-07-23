package com.capgemini.jstk.boardbuddy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.jstk.boardbuddy.dao.LevelDao;
import com.capgemini.jstk.boardbuddy.dao.UserDao;
import com.capgemini.jstk.boardbuddy.dto.UserDto;
import com.capgemini.jstk.boardbuddy.dto.mapper.Mapper;
import com.capgemini.jstk.boardbuddy.entity.Level;

@Service
public class UserService {

	private UserDao userDao;
	private LevelDao levelDao;
	private Mapper mapper;

	@Autowired
	public UserService(UserDao userDao, LevelDao levelDao, Mapper mapper) {
		super();
		this.userDao = userDao;
		this.levelDao = levelDao;
		this.mapper = mapper;
	}

	//TODO how to update level field ?
	public Level findLevel(UserDto userDto) {
		return levelDao.findByScore(userDto.getScore()).get();
	}
	
	public Integer findRankPosition(UserDto userDto) {
		return 
	}
	
	

}
