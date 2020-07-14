package com.spring.mapper;

import java.util.List;

import com.spring.domain.BoardVO;

public interface BoardMapper {
	public int insertArticle(BoardVO vo);
	public List<BoardVO> getlist();
	public BoardVO getArticle(int bno);
	public int updateArticle(BoardVO vo);
	public int deleteArticle(int bno);
}
