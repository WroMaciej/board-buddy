package com.capgemini.jstk.boardbuddy.entity;

import lombok.Getter;
import lombok.Setter;

public class User {
	
	@Getter	@Setter
	private Integer id;
	@Getter	@Setter
	private String firstName;
	@Getter	@Setter
	private String lastName;
	@Getter	@Setter
	private String email;
	@Getter	@Setter
	private String password;
	@Getter	@Setter
	private String lifeMotto;
	@Getter	@Setter
	private Integer score;
	@Getter	@Setter
	private Integer wins;
	@Getter	@Setter
	private Integer losses;
	@Getter	@Setter
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
