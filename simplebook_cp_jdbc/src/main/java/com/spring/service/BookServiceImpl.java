package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.persistence.BookDAO;


import domain.BookVO;

@Service ("book")
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO dao;
	
	@Override
	public List<BookVO> getList() {
		return dao.getList();
	}

	@Override
	public boolean intsert(BookVO vo) {
		dao.insertArticle(vo);
		return false;
	}

	@Override
	public boolean update(BookVO vo) {		
		return dao.updateArticle(vo)==0?false:true;
	}


	@Override
	public boolean delete(String code) {
		int vo = dao.deleteArticle(code);
		return false;
	}

	@Override
	public BookVO getBook(String code) {
		// TODO Auto-generated method stub
		return dao.getRow(code);
	}

}
