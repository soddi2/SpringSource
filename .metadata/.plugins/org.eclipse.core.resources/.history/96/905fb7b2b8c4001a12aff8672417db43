package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.BookVO;
import com.spring.mapper.BookMapper;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookMapper mapper;
	
	@Override
	public boolean insert(BookVO vo) {
		
		return mapper.insert(vo) > 0 ? true:false;
	}

	@Override
	public List<BookVO> BookSelect() {
		
		return mapper.BookSelect();
	}

	@Override
	public boolean modify(String code, int price) {
		return mapper.modify(code, price) > 0 ? true:false;
	}

	@Override
	public boolean delete(String code) {
		return mapper.delete(code) > 0 ? true:false;
	}

	@Override
	public List<BookVO> getList(String criteria,String keyword) {
		
		return mapper.getList(criteria,keyword);
	}

}
