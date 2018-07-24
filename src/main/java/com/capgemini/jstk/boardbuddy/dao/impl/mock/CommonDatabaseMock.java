package com.capgemini.jstk.boardbuddy.dao.impl.mock;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.jstk.boardbuddy.entity.Boardgame;
import com.capgemini.jstk.boardbuddy.entity.ChallengeResult;
import com.capgemini.jstk.boardbuddy.entity.Level;
import com.capgemini.jstk.boardbuddy.entity.StandbyPeriod;
import com.capgemini.jstk.boardbuddy.entity.User;
import com.capgemini.jstk.boardbuddy.entity.UserBoardgame;
import com.capgemini.jstk.boardbuddy.entity.UserChallengeResult;

import lombok.Getter;

@Component
public class CommonDatabaseMock {
	
	@Getter
	private Collection<User> users;
	@Getter
	private Collection<Boardgame> boardgames;
	@Getter
	private Collection<UserBoardgame> userBoardgames;
	@Getter
	private Collection<ChallengeResult> challengeResults;
	@Getter
	private Collection<StandbyPeriod> standbyPeriods;
	@Getter
	private Collection<Level> levels;
	@Getter
	private Collection<UserChallengeResult> userChallengeResults;
	
	@Autowired
	public CommonDatabaseMock() {
		populateUsers();
		populateLevels();
	}
	
	
	
	private boolean populateUsers() {
		users = new ArrayList<>();
		users.add(new User(1, "John", "Trabolta", "johnny@domain.com", "plane", "Lets dance!", 1432, 10, 8, 2));
		users.add(new User(2, "Sandra", "Balock", "sandra@domain.com", "foo", "Lets work!", 1240, 16, 24, 3));
		users.add(new User(3, "Thomas", "Anderson", "neo@secretinternet.com", "theonlyone!!!11oneoneone", "Is this real?", 2890, 99, 0, 1));
		users.add(new User(4, "Scooby", "Doggie", "woaf@domain.com", "woaf", "Woaf Woaf!", 801, 1, 14, 0));
		users.add(new User(5, "Louisse", "Ciccone", "magonna@bestpopsingers.com", "foo", "Why not to sing?", 1600, 54, 6, 4));
		users.add(new User(6, "Boardgame", "Lover", "mr_boardgame@boardgamefans.com", "foOo1", "Boardgame is the best thing man ever invented!", 1010, 34, 30, 10));
		return true;
	}
	
	private boolean populateLevels() {
		levels = new ArrayList<>();
		levels.add(new Level(6, 1, "Rock", 0));
		levels.add(new Level(5, 2, "Dog", 800));
		levels.add(new Level(4, 3, "Kid", 1010));
		levels.add(new Level(3, 4, "Normal", 1200));
		levels.add(new Level(2, 5, "Master", 1600));
		levels.add(new Level(1, 6, "The only one", 2800));	
		return true;
	}


	

}
