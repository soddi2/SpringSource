package com.spring.service;

import java.util.List;

import com.spring.domain.BoardVO;

public interface Boardservice {
	//게시판과 관련된 기능 등록

	int insertBoard(BoardVO vo);
	int updateBoard(BoardVO vo);
	int deleteBoard(BoardVO vo);
	BoardVO getBoard(int bno);
	List<BoardVO> getList();
}
