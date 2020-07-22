package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.AttachFileVO;
import com.spring.mapper.AttachMapper;

@Service
public class AttachServiceImpl implements AttachService {

	@Autowired
	private AttachMapper mapper;
	
	@Override
	public List<AttachFileVO> fileSelect(int bno) {
		return mapper.fileSelect(bno);
	}

	@Override
	public boolean fileUpload(AttachFileVO vo) {
		return mapper.fileUpload(vo) > 0 ? true:false;
	}

	@Override
	public boolean fileDelete(int bno) {
		return mapper.fileDelete(bno) > 0 ? true:false;
	}

}
