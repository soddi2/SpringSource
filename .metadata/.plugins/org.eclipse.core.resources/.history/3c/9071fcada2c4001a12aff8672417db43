package com.spring.service;

import java.util.List;

import com.spring.domain.BookVO;

public interface BookService {
	//도서목록보기 => select
	public List<BookVO> getList();
	
	//도서정보입력 => insert(code,title,writer,price)
	public boolean insert(BookVO vo);
	
	//도서정보수정
	public boolean modify(String code,int price);
	
	//도서정보삭제
	public boolean delete(String code);
	
	//도서정보검색
	public List<BookVO> getSearchList(String criteria,String keyword);
}














