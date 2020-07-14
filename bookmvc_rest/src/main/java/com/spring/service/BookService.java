package com.spring.service;

import java.util.List;

import com.spring.domain.BookVO;

public interface BookService {
	public List<BookVO> BookSelect();
	
	public boolean insert(BookVO vo);
	
	public boolean modify(String code,int price);
	
	public boolean delete(String code);
	
	public List<BookVO> getList(String criteria, String keyword);
	
	public BookVO getRow(String code);
}
