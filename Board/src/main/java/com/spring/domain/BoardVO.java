package com.spring.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BoardVO {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updatedate;
	private int replycnt;
	
	//게시글 등록시 첨부파일 목록, 첨부 파일 받아놓는 필드
	private List<AttachFileVO> attachList;
}
