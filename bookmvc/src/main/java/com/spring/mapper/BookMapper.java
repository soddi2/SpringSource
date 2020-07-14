package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.domain.BookVO;


public interface BookMapper {
	public List<BookVO> BookSelect();
	public int insert(BookVO vo);
	public int delete(String code);
	public List<BookVO> getList(@Param("criteria") String criteria,@Param("keyword") String keyword);
	public int modify(@Param("code") String code,@Param("price") int price);
}
