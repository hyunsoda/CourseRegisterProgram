package edu.kh.toy.register.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 필드에 대한 매개변수 생성자
@ToString
public class Register {

	private int regNo;
	private String clsName;
	private int studentNo;
	private String major;
	
	
}
