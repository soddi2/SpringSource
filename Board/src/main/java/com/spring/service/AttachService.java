package com.spring.service;

import java.util.List;

import com.spring.domain.AttachFileVO;

public interface AttachService {
	public List<AttachFileVO> fileSelect(int bno);
	public boolean fileUpload(AttachFileVO vo);
	public boolean fileDelete(int bno);
}
