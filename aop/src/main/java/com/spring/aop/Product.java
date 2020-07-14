package com.spring.aop;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component  //객체 생성
@Data
@Setter
public class Product {
	private String company;
	private String pname;
	private String price;
	
	//이부분만 따로 class화 시킨다
	public void getInfo() throws Exception{
		System.out.println("메소드 호출됨");
		System.out.println("회사명 : "+company);
		System.out.println("제품명 : "+pname);
		System.out.println("가격 : "+price);
		throw new Exception("예외사항 발생");
	}
}
