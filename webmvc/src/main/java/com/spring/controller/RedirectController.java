package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RedirectController {
	
	@GetMapping("/doA")  //http://localhost:8080/doA
	public String doA(RedirectAttributes rttr) {
		log.info("doA 요청");
		
		//RedirectAttributes : 일회성으로 값을 전달하기 위한 용도(ex)실패한 로그인)
		//파라메터 형식을 보내기
		//path +="?age=10";
		rttr.addAttribute("age", 10); //주소줄 뒤로 따라옴
		
		//sendRedirect 방식 : 응답하는 컨트롤러가 있어야함 왜냐면 주소를 바꿔야하기 때문에
		return "redirect:/member/login"; // http://localhost:8080/ 404:응답하는 컨트롤러가 없음
	}
	
	@GetMapping("/doB") //http://localhost:8080/doB
	public String doB(RedirectAttributes rttr) {
		log.info("doB 요청");
		rttr.addFlashAttribute("age", 10); //세션객체에 담아줌, 메인에서만 한번쓰고 제거
		return "redirect:/"; //http://localhost:8080/
	}
}




























