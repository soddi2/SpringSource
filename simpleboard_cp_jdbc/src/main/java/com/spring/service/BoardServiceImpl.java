package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spring.domain.BoardVO;
import com.spring.persistence.BoardDAO;

//@Component ("board")
@Service("board") //실행
public class BoardServiceImpl implements Boardservice {

	@Autowired //가진거 중에 하나 내놔
	private BoardDAO dao;
	
	@Override
	public int insertBoard(BoardVO vo) {
		return dao.insertArticle(vo);
	}

	@Override
	public int updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return dao.updateArticle(vo);
	}

	@Override
	public int deleteBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return dao.deleteArticle(vo);
	}

	@Override
	public BoardVO getBoard(int bno) {
		// TODO Auto-generated method stub
		return dao.getRow(bno);
	}

	@Override
	public List<BoardVO> getList() {
		return dao.getList();
	}


}
