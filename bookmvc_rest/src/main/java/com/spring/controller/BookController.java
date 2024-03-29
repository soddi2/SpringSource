package com.spring.controller;

import java.io.Reader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.BookVO;
import com.spring.service.BookService;


import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.Post;

@Slf4j
//@RestController
@Controller
//@RequestMapping("/book/*") //book으로 들어오는 모든 요청 처리
public class BookController {

	@GetMapping("/select") // 주소창 경로
	public String select() {
		log.info("도서 목록 폼 요청");

		// /WEB-INF/views/ XXX
		return "book_selectAll"; //주소 이름이 다른경우
	}
	
	@GetMapping("/info")
	public String info() {
		log.info("도서 정보");
		return "book_info";
	}
	
	@GetMapping("/insert")
	public String insert() {
		log.info("도서 정보 입력");
		return "book_insert";
	}
}





























