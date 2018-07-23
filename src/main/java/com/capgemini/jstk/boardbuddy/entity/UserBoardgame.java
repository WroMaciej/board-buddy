package com.capgemini.jstk.boardbuddy.entity;


/**
 * Many to many relation between users and board games
 * @author MACIEWRO
 *
 */
public class UserBoardgame {
	
	private Integer id;
	private Integer userId;
	private Integer boardgameId;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getBoardgameId() {
		return boardgameId;
	}
	public void setBoardgameId(Integer boardgameId) {
		this.boardgameId = boardgameId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	

}
