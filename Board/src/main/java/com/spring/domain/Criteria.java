package com.spring.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Criteria {
	private int pageNum; //페이지번호
	private int amount; //한 페이지당 보여줄 게시물 수
	private String type; //검색조건 name = type
	private String keyword; //검색어 name = keyword
		
	public Criteria() {
		this(1, 10);
	}
	
	public Criteria(int pageNum,int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	//type 값을 받아서 배열로 리턴
	//type : T {"T"} ,C,W,TC,TW {"T","W"} ,TCW {"T","C","W"}
	public String[] getTypeArr() {
		return type == null ? new String[]{}:type.split(""); // {}
	}
}
