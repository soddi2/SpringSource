package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TestController {
	
	@RequestMapping("/test") // http://localhost:8080/test
	public void test() {
		log.info("test 요청....");
	}
	
	@RequestMapping("/login") // http://localhost:8080/login
	public void test2() {
		log.info("test2 요청....");
	}
	
	//잘 안씀? 쫌 다르게 가겠다
	@RequestMapping("/test3") // http://localhost:8080/test3
	public String test3() {
		log.info("test3 요청....");
		return "/sample/test3"; // /WEB-INF/view/XXX/ XXX .jsp 를 달아줌
	}
	
	//같은 경로에 있는 것들끼리 작업하는게 편하다 꼭 그렇게 해야하는건 아니지만.......
	@RequestMapping("/sample/test4") // http://localhost:8080/sample/test4
	public void test4() {
		log.info("test4 요청");
	}
}








