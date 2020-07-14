package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.BookVO;
import com.spring.mapper.BookMapper;


@Service ("book")
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookMapper mapper;
	
	@Override
	public List<BookVO> getList() {
		return mapper.getList();
	}

	@Override
	public boolean intsert(BookVO vo) {
		return mapper.insertArticle(vo)==0?false:true;
	}

	@Override
	public boolean update(BookVO vo) {
		// TODO Auto-generated method stub
		return mapper.updateArticle(vo)==0?false:true;
	}

	@Override
	public boolean delete(String code) {
		// TODO Auto-generated method stub
		return mapper.deleteArticle(code)==0?false:true;
	}

	@Override
	public BookVO getBook(String code) {
		// TODO Auto-generated method stub
		return mapper.getRow(code);
	}

}
