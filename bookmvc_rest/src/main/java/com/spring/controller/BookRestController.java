package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.BookVO;
import com.spring.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BookRestController {

	@Autowired
	private BookService service;
	
	@GetMapping("/list")
	public List<BookVO> list() {
		log.info("도서 목록 가져오기");
		List<BookVO> list = service.BookSelect();
		
		return list;
	}
	
	// http://localhost:8080/1001 + get 
	@GetMapping("/{code}")
	public BookVO getRow(@PathVariable("code") String code) {
		log.info("도서 정보 : "+code);
		return service.getRow(code);
	}
	
	// method = get / post
	// rest = get / post / delete / put(push)
	
	
	// http://localhost:8080/1001 +delete
	@DeleteMapping("/{code}")
	public ResponseEntity<String> delete(@PathVariable("code") String code){
		log.info("도서 정보 삭제 : "+code);
		
		return service.delete(code) ? new ResponseEntity<String>("success",HttpStatus.OK) : 
			new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
	}
	
	// http://localhost:8080/modify + put
	
	@PutMapping("/modify")
	public ResponseEntity<String> update(@RequestBody BookVO vo){
		log.info("도서 정보 수정"+vo);
		return service.modify(vo.getCode(), vo.getPrice()) ? 
				new ResponseEntity<String>("success",HttpStatus.OK) : 
				new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
	}
	
	//도서정보입력
	// http://localhost:8080/insert + put
	
	@PostMapping("/insert")
	public ResponseEntity<String> insert(@RequestBody BookVO vo){
		log.info("도서 정보 입력"+vo);
		return service.insert(vo) ?
				new ResponseEntity<String>("success",HttpStatus.OK) : 
				new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
	}
}






















