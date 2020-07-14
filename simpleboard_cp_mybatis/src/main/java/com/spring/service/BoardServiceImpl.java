package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spring.domain.BoardVO;
import com.spring.mapper.BoardMapper;

//@Component ("board")
@Service("board") //실행
public class BoardServiceImpl implements Boardservice {

	@Autowired //가진거 중에 하나 내놔
	private BoardMapper mapper;
	
	@Override
	public int insertBoard(BoardVO vo) {
		return mapper.insertArticle(vo);
	}

	@Override
	public int updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return mapper.updateArticle(vo);
	}

	@Override
	public int deleteBoard(int bno) {
		// TODO Auto-generated method stub
		return mapper.deleteArticle(bno);
	}

	@Override
	public BoardVO getBoard(int bno) {
		// TODO Auto-generated method stub
		return mapper.getArticle(bno);
	}

	@Override
	public List<BoardVO> getList() {
		return mapper.getlist();
	}


}
