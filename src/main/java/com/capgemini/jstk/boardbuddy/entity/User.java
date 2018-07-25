package com.capgemini.jstk.boardbuddy.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
	
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String lifeMotto;
	private Integer score;
	private Integer wins;
	private Integer losses;
	private Integer draws;
	
	public User(Integer id, String firstName, String lastName, String email, String password, String lifeMotto,
			Integer score, Integer wins, Integer losses, Integer draws) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.lifeMotto = lifeMotto;
		this.score = score;
		this.wins = wins;
		this.losses = losses;
		this.draws = draws;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
	
	
	
	
	

	
}
