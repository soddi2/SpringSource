package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;
import com.spring.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;
	
	@Override
	public boolean register(BoardVO register) {
		
		return mapper.register(register) > 0 ? true:false;
	}

	@Override
	public BoardVO read(BoardVO read) {
		return mapper.read(read);
	}

	@Override
	public boolean modify(BoardVO modify) {
		
		return mapper.modify(modify) > 0 ? true:false;
	}

	@Override
	public boolean delete(int bno) {
		
		return mapper.delete(bno) > 0 ? true:false;
	}

	@Override
	public List<BoardVO> list(Criteria cri) {
		return mapper.list(cri);
	}

	@Override
	public int total(Criteria cri) {
		return mapper.total(cri);
	}

	@Override
	public int updateReply(int bno, int amount) {
		return mapper.updateReplyCnt(bno, amount);
	}

}
