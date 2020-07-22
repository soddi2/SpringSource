package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.domain.AttachFileVO;
import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;
import com.spring.mapper.AttachMapper;
import com.spring.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;
	
	@Autowired
	private AttachMapper attach;
	
	@Transactional
	@Override
	public boolean register(BoardVO register) {
		//게시글 db 저장 요청
		boolean result = mapper.register(register) > 0 ? true:false;
		
		//bno 때문에 첨부파일은 게시글이 들어간 다음 들어가야함
		//첨부파일 db 저장 요청
		if(register.getAttachList() == null || register.getAttachList().size() <= 0) {
			return result;
		}
		
		//람다 식 : 인터페이스가 가지고 있는 메소드를 간편하게 즉흥적으로 구현하는 것
		register.getAttachList().forEach(attach1 -> {
			attach1.setBno(register.getBno());
			attach.fileUpload(attach1);
		});
		
		return true;
	}

	@Override
	public BoardVO read(BoardVO read) {
		return mapper.read(read);
	}

	@Override
	public boolean modify(BoardVO modify) {
		//현재 bno의 게시물 db에서 삭제
		attach.fileDelete(modify.getBno());
		//첨부파일을 다시 삽입
		//리스트가 가지고 있는 거만큼 루프를 돌려서 인설트를 해줘라
		if(modify.getAttachList() != null && modify.getAttachList().size() >= 0) {
			for(AttachFileVO attach1 : modify.getAttachList()) {
				attach1.setBno(modify.getBno());
				attach.fileUpload(attach1);			
			}
		}
		
		return mapper.modify(modify) > 0 ? true:false;
	}
	
	@Transactional
	@Override
	public boolean delete(int bno) {
		attach.fileDelete(bno);
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

	@Override
	public List<AttachFileVO> attachList(int bno) {
		return attach.fileSelect(bno);
	}

}
