package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.domain.BookVO;

public interface BookMapper {
	public List<BookVO> select();
	public int insert(BookVO vo);
	public int delete(String code);
	public int update(@Param("code") String code,@Param("price") int price);
	public List<BookVO> search(@Param("criteria") String criteria,
					@Param("keyword") String keyword);
}
















