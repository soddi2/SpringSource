package com.spring.service;

import java.util.List;

import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;

public interface BoardService {
	
	//인터페이스는 기본적으로 public이기 때문에 안써도 됨
	public List<BoardVO> list(Criteria cri);
	public int total(Criteria cri);
	public boolean register(BoardVO register);
	public BoardVO read(BoardVO read);
	public boolean modify(BoardVO modify);
	public boolean delete(int bno);
}
