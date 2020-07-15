package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.PartnerVO;
import com.spring.service.PartnerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/partner/*")
public class PartnerController {

	@Autowired //객체 주입
	private PartnerService service; // = new PartnerServiceImpl(); 활성화 필요
	
	@GetMapping("/register")
	public void registerGet() {
		log.info("파트너 입력 폼 요청");
	}
	
	@PostMapping("/register")
	public String registerPost(PartnerVO vo) {
		log.info(""+vo);
		
		boolean YDH = service.create(vo);
		
		if(YDH) {
			return "/partner/list";
		}
		
		return "register";
	}
	
}

















