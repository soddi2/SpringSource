package com.spring.controller;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UploadController {

	//upload폼을 보여주는 컨트롤러
	@GetMapping("/uploadForm")
	public void upload() {
		log.info("업로드 페이지 구동");
	}
	
	@PostMapping("/uploadForm")
	public void uploadPost(MultipartFile[] uploadFile) {
		log.info("upload 요청");
		String uploadPath = "d:\\upload";
		
		for(MultipartFile f:uploadFile) {
			log.info("---------------------");
			log.info("upload File Name : "+f.getOriginalFilename());
			log.info("upload File Size : "+f.getSize());
			
			//서버 폴더에 파일 저장 (File, Path 객체로 저장)
			File saveFile = new File(uploadPath,f.getOriginalFilename());
			
			try {
				f.transferTo(saveFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			
		}
	}
		
	//다운로드 컨트롤러
	@GetMapping(value="/download",produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody //뷰를 통하지 않고 바로 http로 넘어감
	public ResponseEntity<Resource> downloadFile(String fileName) {
		log.info("다운로드 파일 : "+fileName);
		
		Resource resource = new FileSystemResource("d:\\upload\\"+fileName);
		
		String resourceName = resource.getFilename();
		
		//브라우저 헤더에 붙여 보내기
		HttpHeaders headers = new HttpHeaders();
		try {
			headers.add("Content-Disposition", "attachment;fileName="
					+new String(resourceName.getBytes("utf-8"),"ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {			
			e.printStackTrace();
		}
		return new ResponseEntity<Resource>(resource,headers,HttpStatus.OK);
	}
}













