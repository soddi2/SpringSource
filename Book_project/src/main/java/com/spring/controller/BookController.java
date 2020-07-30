package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/rent/*")
public class BookController {
	
	@GetMapping("rent")
	public void rent() {
		log.info("상세 페이지 form");
	}
}
