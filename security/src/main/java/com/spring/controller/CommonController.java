package com.spring.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CommonController {

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/accessError")
	public String accessError(Authentication auth,Model model) {
		log.info("접근 제한 URI "+auth);
		model.addAttribute("msg","Access Denied");
		
		return "/security/accessError";
	}
}
