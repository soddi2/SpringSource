package com.spring.domain;

import lombok.Data;

@Data
public class AttachFileVO {
	private String uuid;
	private String uploadPath;
	private String fileName;
	private boolean fileType;
}
