package com.capgemini.jstk.boardbuddy.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.jstk.boardbuddy.dao.LevelDao;
import com.capgemini.jstk.boardbuddy.dao.UserBoardgameDao;
import com.capgemini.jstk.boardbuddy.dao.UserDao;
import com.capgemini.jstk.boardbuddy.dto.BoardgameDto;
import com.capgemini.jstk.boardbuddy.dto.LevelDto;
import com.capgemini.jstk.boardbuddy.dto.UserDto;

@Service
public class UserService {

	private UserDao userDao;
	private LevelDao levelDao;
	private UserBoardgameDao userBoardgameDao;

	

	@Autowired
	public UserService(UserDao userDao, LevelDao levelDao, UserBoardgameDao userBoardgameDao) {
		this.userDao = userDao;
		this.levelDao = levelDao;
		this.userBoardgameDao = userBoardgameDao;
	}

	//TODO how to update level field ?
	public LevelDto findLevel(UserDto userDto) {
		return levelDao.findByScore(userDto.getScore()).get();
	}
	
	public boolean updateLevel(UserDto userDto) {
		userDto.setLevelValue(findLevel(userDto).getLevelValue());
		return true;
	}
	
	public Optional<Integer> findRankPosition(UserDto userDto) {
		List<UserDto> sortedByScore = userDao.findAllUsers();
		sortedByScore.sort((user1, user2) -> user1.getScore() - user2.getScore());
		Integer rankPosition = sortedByScore.indexOf(userDto) + 1;
		if (rankPosition == -1) {
			rankPosition = null;
		}
		return Optional.ofNullable(rankPosition);
	}
	
	public Collection<BoardgameDto> findUserBoardgames(UserDto userDto){
		return userBoardgameDao.findBoardgamesByUser(userDto);
	}
	
	
	

}
