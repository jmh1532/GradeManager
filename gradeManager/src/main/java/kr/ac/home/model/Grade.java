package kr.ac.home.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Grade {
	private int year;
	private int semester;
	private String division;
	private int score;
	@NotEmpty(message="The code address cannot be empty")
	private String code;
	@NotEmpty(message="The lecture  cannot be empty")
	private String lecture;
	
}