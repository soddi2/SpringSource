package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.ClientVO;
import com.spring.service.ClientService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/register/*")
public class MemberController {
	
	@Autowired
	private ClientService service;
	
	@GetMapping("/register")
	public void register() {
		log.info("register form 보여주기");
	}
	
	@PostMapping("/register")
	public String registerPost(ClientVO vo) {
		log.info("register 페이지 보여주기" + vo);
		
		boolean register = service.register(vo);
		
		if(register) {
			return "redirect:/";
		}
		
		return "/register/register";		
	}
}
