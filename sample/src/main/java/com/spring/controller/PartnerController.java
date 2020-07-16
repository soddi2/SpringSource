package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.PartnerVO;
import com.spring.service.PartnerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PartnerController {

	@Autowired //객체 주입
	private PartnerService service; // = new PartnerServiceImpl(); 활성화 필요
	
	@GetMapping("/partner/register")
	public void registerGet() { 
		log.info("파트너 입력 폼 요청");
	}
	
	//forward : model이랑 많이 쓰임 request 담기로 많이 쓰인다 
	//redirect : 경로 session에 담기고 새롭게 경로가 생기고 모델에 담기지 않는다 그렇다고 세션에 모든걸 담고 갈수 없다 서버에 부담이기 떄문에 중요한 정보만 redirect로 보낸다
	//web은 기본적으로 요청을 계속 받는게 아니라 받고 끈고 하기 때문에 계속 응답을 보내고 싶으면 request로 담거나 session에 담아 갈수 있다.
	//http://localhost:8080/partner/register 포워드 방식
	
	//String : String으로 리턴된 값(예를 들어 test라 할 때)
	//보여지는 페이지와 주소가 다른 경우 => Forward
	//void : 요청 주소 뒤에 .jsp만 붙여서 페이지를 찾게 됨 => localhost:8080/WEB-INF/views/test.jsp를 찾게 됨 무조건
	
	//String 1.페이지값
	//		 2.redirect를 붙이는 순간 /WEB-INF/views/test.jsp는 를 붙이는건 하지않고 주소를 새롭개 작성하는 작업(localhost:8080 부터 시작)입니다.
	//redirect를 하는 순간 그거에 맞는 주소가 controller에 있어야 함
	//redirect로 하는 것들 삭제 조회 입력 조회 수정 등 DB작업을 하고 확인을 하는데 있어서 필요함 
	//redirect는 조회로 들어가는 반복작업을 기능을 줘서 작업 할수 있게 해줌

	@PostMapping("/partner/register")
	public String registerPost(PartnerVO vo) { 
		log.info(""+vo);
		
		boolean YDH = service.create(vo);
		
		// /xxx로 루트를 붙이면 무조건 8080이 붙고 루트를 안 붙히면 시작했던 주소에서 뒤에만 바뀜
		// http://localhost:8080/partner/register 여기서 루트 안붙이면 register가 list로 바뀌고 루트 붙이면 8080뒤에 /list로 들어옴
		
		if(YDH) {
			return "redirect:/partner/list"; 
		}
		
		return "/register";
	}
	
	@GetMapping("/exam/test")
	public void test() { // WEB-INF/views/exam/test.jsp
		log.info("test 폼");
	}
	
	@GetMapping("/partner/list")
	public void read(Model model) { //request로 담아가기
		log.info("리스트 요청");
		
		List<PartnerVO> list = service.read();
		model.addAttribute("list", list);
	
	}
}

















