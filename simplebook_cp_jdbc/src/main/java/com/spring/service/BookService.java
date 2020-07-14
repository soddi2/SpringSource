package com.spring.service;

import java.util.List;

import domain.BookVO;

public interface BookService {
	public List<BookVO> getList();
	public boolean intsert(BookVO vo);
	public boolean update(BookVO vo);
	public boolean delete(String code);
	public BookVO getBook(String code);
}
