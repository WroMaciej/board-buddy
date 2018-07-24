package com.capgemini.jstk.boardbuddy.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.jstk.boardbuddy.dao.LevelDao;
import com.capgemini.jstk.boardbuddy.dao.UserDao;
import com.capgemini.jstk.boardbuddy.dto.LevelDto;
import com.capgemini.jstk.boardbuddy.dto.UserDto;

@Service
public class UserService {

	private UserDao userDao;
	private LevelDao levelDao;

	@Autowired
	public UserService(UserDao userDao, LevelDao levelDao) {
		this.userDao = userDao;
		this.levelDao = levelDao;
	}

	//TODO how to update level field ?
	public LevelDto findLevel(UserDto userDto) {
		return levelDao.findByScore(userDto.getScore()).get();
	}
	
	public Optional<Integer> findRankPosition(UserDto userDto) {
		List<UserDto> sortedByScore = userDao.findAllUsers();
		sortedByScore.sort((user1, user2) -> user1.getScore() - user2.getScore());
		Integer rankPosition = sortedByScore.indexOf(userDto);
		return Optional.of(rankPosition);
	}
	
	

}
