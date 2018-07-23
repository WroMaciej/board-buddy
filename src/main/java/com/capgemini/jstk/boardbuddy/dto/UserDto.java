package com.capgemini.jstk.boardbuddy.dto;

public class UserDto {
		
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String lifeMotto;
	private Integer score;
	
	
	private Integer rankPosition;
	private Integer level;
	
	
	
	
	public Integer getLevel() {
		return level;
	}
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLifeMotto() {
		return lifeMotto;
	}
	public void setLifeMotto(String lifeMotto) {
		this.lifeMotto = lifeMotto;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	
	

}
