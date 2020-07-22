package com.spring.mapper;

import java.util.List;

import com.spring.domain.AttachFileVO;

public interface AttachMapper {
	public List<AttachFileVO> fileSelect(int bno);
	public int fileUpload(AttachFileVO vo);
	public int fileDelete(int bno);
	public List<AttachFileVO> getYesterdayFiles();
}
