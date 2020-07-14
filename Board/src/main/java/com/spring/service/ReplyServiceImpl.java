package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.Criteria;
import com.spring.domain.ReplyVO;
import com.spring.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyMapper mapper;

	@Override
	public boolean replyInsert(ReplyVO vo) {
		return mapper.insert(vo) > 0 ? true:false;
	}

	@Override
	public ReplyVO readreply(int rno) {
		return mapper.read(rno);
	}

	@Override
	public boolean replyUpdate(ReplyVO vo) {
		
		return mapper.update(vo) > 0 ? true:false;
	}

	@Override
	public boolean replyDelete(int rno) {
		return mapper.delete(rno) > 0 ? true:false;
	}

	@Override
	public List<ReplyVO> replylist(Criteria cri, int bno) {	
		return mapper.list(cri, bno);
	}

}
