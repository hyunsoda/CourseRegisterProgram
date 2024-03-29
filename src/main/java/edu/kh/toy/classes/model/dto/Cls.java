package edu.kh.toy.classes.model.dto;

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
public class Cls{

	private int clsNo;
	private String clsName;
	private String major;
}
