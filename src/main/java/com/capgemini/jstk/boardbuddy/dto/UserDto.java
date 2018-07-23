package com.capgemini.jstk.boardbuddy.dto;

import lombok.Getter;
import lombok.Setter;

public class UserDto {
		
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
	private Integer rankPosition;
	@Getter	@Setter
	private Integer level;
		

}
