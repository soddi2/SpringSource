package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
	
	@RequestMapping("/read")
	public void read() {
		log.info("read 요청");
	}
	
	@RequestMapping("/register")
	public void register() {
		log.info("register 요청");
	}
	
	@RequestMapping("/modify")
	public void modify() {
		log.info("modify 요청");
	}
	
	@RequestMapping("/list")
	public void list() {
		log.info("list 요청");
	}
}
