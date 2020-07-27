package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/security/*")
public class SecurityController {

	@GetMapping("/all")
	public void allAccess() {
		log.info("모든 사용자 접근 가능");
	}
	
	@GetMapping("/member")
	public void memberAccess() {
		log.info("로그인한 사용자 접근 가능");
	}
	
	@GetMapping("/admin")
	public void adminAccess() {
		log.info("로그인한 사용자 중에서 관리자만  접근 가능");
	}
	
	@GetMapping("/login")
	public void loginForm(String error,String logout,Model model) {
		log.info("로그인 페이지 요청");
		log.info("error "+error);
		log.info("logout "+logout);
		
		if(error != null) {
			model.addAttribute("error","아이디나 비밀번호를 확인해 주세요");
		}
	}
	
//	@GetMapping("/logout")
//	public void logoutForm() {
//		log.info("로그아웃 페이지 요청");
//	}
	
}
















