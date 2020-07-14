package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;
import com.spring.domain.ReplyVO;
import com.spring.service.ReplyService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/replies/*")
public class ReplyController {
	
	@Autowired
	private ReplyService service;
	
	@PostMapping("/new")  //http://localhost:8080/replies/new + post
	public ResponseEntity<String> create(@RequestBody ReplyVO vo) {
		log.info("댓글 등록..."+vo);
		
		return service.replyInsert(vo)?
				new ResponseEntity<String>("success",HttpStatus.OK):
					new ResponseEntity<String>("fail",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	//댓글 하나 가져오기 http://localhost:8080/replies/rno
	@GetMapping("/{rno}")
	public ResponseEntity<ReplyVO> read(@PathVariable("rno") int rno){
		log.info("댓글 하나 가져오기"+rno);
		
		return new ResponseEntity<>(service.readreply(rno),HttpStatus.OK);
	}
	
	
	//댓글 수정하기 http://localhost:8080/replies/3 + put
	@PutMapping("/{rno}")
	public ResponseEntity<String> modify(@RequestBody ReplyVO vo,@PathVariable("rno") int rno){
		log.info("댓글 번호 "+rno+" 내용 "+vo);
		
		//rno를 vo 에 담아주기
		vo.setRno(rno);
		
		return service.replyUpdate(vo)?
				new ResponseEntity<String>("success",HttpStatus.OK):
					new ResponseEntity<String>("fail",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//댓글 삭제 하기 http://localhost:8080/replies/3 + rno
	@DeleteMapping("/{rno}")
	public ResponseEntity<String> delete(@PathVariable("rno") int rno){
		log.info("댓글 삭제 "+rno);
		
		return service.replyDelete(rno)?
				new ResponseEntity<String>("success",HttpStatus.OK):
					new ResponseEntity<String>("fail",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//글번호에 해당하는 댓글 리스트 가져오기
	// http://localhost:8080/replies/pages/{bno}/{pageNum}
	// http://localhost:8080/replies/pages/1068/3
	// 1068에 해당하는 첫번째 페이지 댓글 가져오기
	@GetMapping("/pages/{bno}/{pageNum}")
	public ResponseEntity<List<ReplyVO>> replylist(@PathVariable("bno") int bno,@PathVariable("pageNum") int page){
		log.info("댓글 가져오기 "+bno+" page = "+page);
		
		Criteria cri = new Criteria(page, 10);
		
		return new ResponseEntity<List<ReplyVO>>(service.replylist(cri, bno),HttpStatus.OK);
	}
}

























