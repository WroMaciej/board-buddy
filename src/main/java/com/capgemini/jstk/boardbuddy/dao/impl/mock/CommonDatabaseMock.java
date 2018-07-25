package com.capgemini.jstk.boardbuddy.dao.impl.mock;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.events.Event.ID;

import com.capgemini.jstk.boardbuddy.entity.Boardgame;
import com.capgemini.jstk.boardbuddy.entity.ChallengeResult;
import com.capgemini.jstk.boardbuddy.entity.Level;
import com.capgemini.jstk.boardbuddy.entity.StandbyPeriod;
import com.capgemini.jstk.boardbuddy.entity.User;
import com.capgemini.jstk.boardbuddy.entity.UserBoardgame;
import com.capgemini.jstk.boardbuddy.entity.UserChallengeResult;
import com.capgemini.jstk.boardbuddy.validation.exceptions.DataPreparingException;
import com.capgemini.jstk.boardbuddy.validation.exceptions.NoSuchElementInDatabase;

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
		populateBoardgames();
		populateUserBoardgames();
		populateChallengeResults();
		populateUserChallengeResults();
	}

	private boolean populateUsers() {
		try {
			users = new ArrayList<>();
			users.add(new User(1, "John", "Trabolta", "johnny@domain.com", "plane", "Lets dance!", 1432, 10, 8, 2));
			users.add(new User(2, "Sandra", "Balock", "sandra@domain.com", "foo", "Lets work!", 1240, 16, 24, 3));
			users.add(new User(3, "Thomas", "Anderson", "neo@secretinternet.com", "theonlyone!!!11oneoneone",
					"Is this real?", 2890, 99, 0, 1));
			users.add(new User(4, "Scooby", "Doggie", "woaf@domain.com", "woaf", "Woaf Woaf!", 801, 1, 14, 0));
			users.add(new User(5, "Louisse", "Ciccone", "magonna@bestpopsingers.com", "foo", "Why not to sing?", 1600,
					54, 6, 4));
			users.add(new User(6, "Boardgame", "Lover", "mr_boardgame@boardgamefans.com", "foOo1",
					"Boardgame is the best thing man ever invented!", 1010, 34, 30, 10));
		} catch (Exception e) {
			throw new DataPreparingException("Preparing of users crashed.");
		}
		return true;
	}

	private boolean populateLevels() {
		try {
			levels = new ArrayList<>();
			levels.add(new Level(6, 1, "Rock", 0));
			levels.add(new Level(5, 2, "Dog", 800));
			levels.add(new Level(4, 3, "Kid", 1010));
			levels.add(new Level(3, 4, "Normal", 1200));
			levels.add(new Level(2, 5, "Master", 1600));
			levels.add(new Level(1, 6, "The only one", 2800));
		} catch (Exception e) {
			throw new DataPreparingException("Preparing of levels crashed.");
		}
		return true;
	}

	private boolean populateBoardgames() {
		try {
			boardgames = new ArrayList<>();
			boardgames.add(new Boardgame(1, "Chess"));
			boardgames.add(new Boardgame(2, "Duopoly"));
			boardgames.add(new Boardgame(3, "BaBINGton on board"));
			boardgames.add(new Boardgame(4, "Ping Pong boardgame edition"));
			boardgames.add(new Boardgame(5, "NobodyWantsMe"));
			boardgames.add(new Boardgame(6, "Everybody wants me!"));
		} catch (Exception e) {
			throw new DataPreparingException("Preparing of boardgames crashed.");
		}
		return true;
	}

	private boolean populateUserBoardgames() {
		try {
			userBoardgames = new ArrayList<>();
			// user id 1
			userBoardgames.add(new UserBoardgame(1, 1, 1));
			userBoardgames.add(new UserBoardgame(2, 1, 2));
			userBoardgames.add(new UserBoardgame(3, 1, 3));
			userBoardgames.add(new UserBoardgame(4, 1, 4));
			userBoardgames.add(new UserBoardgame(5, 1, 5));
			userBoardgames.add(new UserBoardgame(6, 1, 6));
			// user id 2
			userBoardgames.add(new UserBoardgame(7, 2, 1));
			userBoardgames.add(new UserBoardgame(8, 2, 3));
			userBoardgames.add(new UserBoardgame(9, 2, 6));
			// user id 3
			userBoardgames.add(new UserBoardgame(10, 3, 2));
			userBoardgames.add(new UserBoardgame(11, 3, 6));
			// user id 4
			userBoardgames.add(new UserBoardgame(12, 4, 1));
			userBoardgames.add(new UserBoardgame(13, 4, 2));
			userBoardgames.add(new UserBoardgame(14, 4, 3));
			// user id 5
			userBoardgames.add(new UserBoardgame(15, 5, 1));
			userBoardgames.add(new UserBoardgame(16, 5, 2));
			userBoardgames.add(new UserBoardgame(17, 5, 3));
			userBoardgames.add(new UserBoardgame(18, 5, 6));
			// user id 6
			userBoardgames.add(new UserBoardgame(19, 6, 6));

		} catch (Exception e) {
			throw new DataPreparingException("Preparing of users boardgames crashed.");
		}

		return true;
	}

	private boolean populateChallengeResults() {
		try {
			challengeResults = new ArrayList<>();
			challengeResults.add(new ChallengeResult(1, 1, new GregorianCalendar(2018, 7, 1, 12, 0),
					new GregorianCalendar(2018, 7, 1, 18, 0)));
			challengeResults.add(new ChallengeResult(2, 3, new GregorianCalendar(2018, 7, 2, 16, 0),
					new GregorianCalendar(2018, 7, 2, 17, 0)));
			challengeResults.add(new ChallengeResult(3, 2, new GregorianCalendar(2018, 7, 3, 10, 0),
					new GregorianCalendar(2018, 7, 20, 18, 0)));
			challengeResults.add(new ChallengeResult(4, 6, new GregorianCalendar(2018, 7, 4, 14, 0),
					new GregorianCalendar(2018, 7, 4, 14, 30)));
			challengeResults.add(new ChallengeResult(5, 4, new GregorianCalendar(2018, 7, 5, 13, 0),
					new GregorianCalendar(2018, 7, 5, 15, 0)));
			challengeResults.add(new ChallengeResult(6, 1, new GregorianCalendar(2018, 7, 6, 17, 0),
					new GregorianCalendar(2018, 7, 6, 19, 0)));
		} catch (Exception e) {
			throw new DataPreparingException("Preparing of challenge results crashed.");
		}
		return true;
	}
	
	private boolean populateUserChallengeResults() {
		try {
			userChallengeResults = new ArrayList<>();
			//challenge 1
			userChallengeResults.add(new UserChallengeResult(1, 1, 1, 3));
			userChallengeResults.add(new UserChallengeResult(2, 2, 1, 2));
			userChallengeResults.add(new UserChallengeResult(3, 3, 1, 1));
			//challenge 2
			userChallengeResults.add(new UserChallengeResult(4, 1, 2, 1));
			userChallengeResults.add(new UserChallengeResult(5, 5, 2, 2));
			userChallengeResults.add(new UserChallengeResult(6, 6, 2, 3));
			//challenge 3
			userChallengeResults.add(new UserChallengeResult(7, 3, 3, 1));
			userChallengeResults.add(new UserChallengeResult(8, 4, 3, 2));
			//challenge 4
			userChallengeResults.add(new UserChallengeResult(9, 1, 4, 2));
			userChallengeResults.add(new UserChallengeResult(10, 5, 4, 1));
			//challenge 5
			userChallengeResults.add(new UserChallengeResult(11, 3, 5, 1));
			userChallengeResults.add(new UserChallengeResult(12, 6, 5, 2));
			//challenge 6 - draw!
			userChallengeResults.add(new UserChallengeResult(13, 1, 6, 1));
			userChallengeResults.add(new UserChallengeResult(14, 3, 6, 1));		
			
		} catch (Exception e) {
			throw new DataPreparingException("Preparing of challenge results crashed.");
		}
		return true;
		
	}

}
