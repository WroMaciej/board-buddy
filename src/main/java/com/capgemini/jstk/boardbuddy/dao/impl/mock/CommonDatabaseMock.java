package com.capgemini.jstk.boardbuddy.dao.impl.mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.jstk.boardbuddy.entity.Boardgame;
import com.capgemini.jstk.boardbuddy.entity.ChallengeResult;
import com.capgemini.jstk.boardbuddy.entity.Level;
import com.capgemini.jstk.boardbuddy.entity.StandbyPeriod;
import com.capgemini.jstk.boardbuddy.entity.User;
import com.capgemini.jstk.boardbuddy.entity.User_Boardgame_X;
import com.capgemini.jstk.boardbuddy.entity.User_ChallengeResult_X;
import com.capgemini.jstk.boardbuddy.validation.exceptions.DataPreparingException;

import lombok.Getter;

@Component
public class CommonDatabaseMock {

	@Getter
	private Collection<User> users;
	@Getter
	private Collection<Boardgame> boardgames;
	@Getter
	private Collection<User_Boardgame_X> user_Boardgame_Xs;
	@Getter
	private Collection<ChallengeResult> challengeResults;
	@Getter
	private Collection<StandbyPeriod> standbyPeriods;
	@Getter
	private Collection<Level> levels;
	@Getter
	private Collection<User_ChallengeResult_X> user_ChallengeResult_Xs;

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
			user_Boardgame_Xs = new ArrayList<>();
			// user id 1
			user_Boardgame_Xs.add(new User_Boardgame_X(1, 1, 1));
			user_Boardgame_Xs.add(new User_Boardgame_X(2, 1, 2));
			user_Boardgame_Xs.add(new User_Boardgame_X(3, 1, 3));
			user_Boardgame_Xs.add(new User_Boardgame_X(4, 1, 4));
			user_Boardgame_Xs.add(new User_Boardgame_X(5, 1, 5));
			user_Boardgame_Xs.add(new User_Boardgame_X(6, 1, 6));
			// user id 2
			user_Boardgame_Xs.add(new User_Boardgame_X(7, 2, 1));
			user_Boardgame_Xs.add(new User_Boardgame_X(8, 2, 3));
			user_Boardgame_Xs.add(new User_Boardgame_X(9, 2, 6));
			// user id 3
			user_Boardgame_Xs.add(new User_Boardgame_X(10, 3, 2));
			user_Boardgame_Xs.add(new User_Boardgame_X(11, 3, 6));
			// user id 4
			user_Boardgame_Xs.add(new User_Boardgame_X(12, 4, 1));
			user_Boardgame_Xs.add(new User_Boardgame_X(13, 4, 2));
			user_Boardgame_Xs.add(new User_Boardgame_X(14, 4, 3));
			// user id 5
			user_Boardgame_Xs.add(new User_Boardgame_X(15, 5, 1));
			user_Boardgame_Xs.add(new User_Boardgame_X(16, 5, 2));
			user_Boardgame_Xs.add(new User_Boardgame_X(17, 5, 3));
			user_Boardgame_Xs.add(new User_Boardgame_X(18, 5, 6));
			// user id 6
			user_Boardgame_Xs.add(new User_Boardgame_X(19, 6, 6));

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
			user_ChallengeResult_Xs = new ArrayList<>();
			//challenge 1
			user_ChallengeResult_Xs.add(new User_ChallengeResult_X(1, 1, 1, 3));
			user_ChallengeResult_Xs.add(new User_ChallengeResult_X(2, 2, 1, 2));

			//challenge 2
			user_ChallengeResult_Xs.add(new User_ChallengeResult_X(3, 1, 2, 1));
			user_ChallengeResult_Xs.add(new User_ChallengeResult_X(4, 5, 2, 2));

			//challenge 3
			user_ChallengeResult_Xs.add(new User_ChallengeResult_X(5, 3, 3, 1));
			user_ChallengeResult_Xs.add(new User_ChallengeResult_X(6, 4, 3, 2));
			//challenge 4
			user_ChallengeResult_Xs.add(new User_ChallengeResult_X(7, 1, 4, 2));
			user_ChallengeResult_Xs.add(new User_ChallengeResult_X(8, 5, 4, 1));
			//challenge 5
			user_ChallengeResult_Xs.add(new User_ChallengeResult_X(9, 3, 5, 1));
			user_ChallengeResult_Xs.add(new User_ChallengeResult_X(10, 6, 5, 2));
			//challenge 6 - draw!
			user_ChallengeResult_Xs.add(new User_ChallengeResult_X(11, 1, 6, 1));
			user_ChallengeResult_Xs.add(new User_ChallengeResult_X(12, 3, 6, 1));		
			
		} catch (Exception e) {
			throw new DataPreparingException("Preparing of challenge results crashed.");
		}
		return true;
	}
	
	private void populateStandbyPeriods() {
		try {
			standbyPeriods = new ArrayList<>();
			standbyPeriods.add(new StandbyPeriod(1, 1, new GregorianCalendar(2018, 7, 25, 8, 0), new GregorianCalendar(2018, 7, 25, 8, 0), null, true);	
		} catch (Exception e) {
			throw new DataPreparingException("Preparing of standby periods crashed.");
		}
	}

}
