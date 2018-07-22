package com.capgemini.jstk.boardbuddy.service.score.calculator;

import java.util.Map;

import com.capgemini.jstk.boardbuddy.entity.ChallengeResult;
import com.capgemini.jstk.boardbuddy.entity.User;

public interface ScoreCalculatorService {

	/**
	 * 
	 * @param challengeResult
	 * @return
	 * KEY - user
	 * VALUE - its new score
	 */
	public  Map<User, Integer> calculateScoresAfterChallenge(ChallengeResult challengeResult);
}
