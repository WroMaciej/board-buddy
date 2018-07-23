package com.capgemini.jstk.boardbuddy.dto;

import lombok.Getter;
import lombok.Setter;

public class LevelDto {
	
	@Getter	@Setter
	private Integer id;
	@Getter	@Setter
	private Integer levelValue;
	@Getter	@Setter
	private String name;
	@Getter	@Setter
	private Integer minScore;

}
