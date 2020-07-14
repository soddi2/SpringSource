package com.spring.mapper;

import java.util.List;

import com.spring.domain.BookVO;

public interface BookMapper {
	public int insertArticle(BookVO vo);
	public int updateArticle(BookVO vo);
	public int deleteArticle(String code);
	public List<BookVO> getList();
	public BookVO getRow(String code);
	
}
