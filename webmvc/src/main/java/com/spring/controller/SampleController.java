package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/sample") // 무조건 들어오고 http://localhost:8080 /sample
public class SampleController {
	//컨트롤러 안에 작성한 메소드와 @RequestMapping과 연결하면 사용자의 요구와 응답하는 처리를 만들어 낼 수 있음
	@RequestMapping("/basic") //http://localhost:8080/sample/basic
	public void basic() { // void : 주소 경로 자체가 .jsp로 됨
		log.info("basic 요청....");
		// /sample/basic
	}
	
	@RequestMapping("/test") // http://localhost:8080/test
	public void test() {
		log.info("test 요청...");
	}
	
	@RequestMapping("/login") // http://localhost:8080/sample/login
	public String login() {
		log.info("login 요청....");
		return "signin"; // /WEB-INF/view/ XXX .jsp 를 달아줌
	}
}
