package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.PartnerVO;
import com.spring.service.PartnerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/partner/*")
public class PartnerController {

	@Autowired
	private PartnerService service;
	
	@GetMapping("/register")
	public void register() {
		log.info("register 페이지 동작");
	}
	
	@PostMapping("/register")
	public String registerPost(PartnerVO vo,RedirectAttributes rttr) {
		log.info(""+vo);
		
		try {
			boolean insert = service.register(vo);
			if(insert) {
				rttr.addFlashAttribute("result", vo.getName());
				return "redirect:/partner/list";
			}else {
				return "/partner/register";			
			}
		} catch (Exception e) {
			return "/partner/register";
		}
	}
	
	@GetMapping("/list")
	public String readPost(Model model) {
		
		List<PartnerVO> list = service.read();
		model.addAttribute("list",list);
		
		return "/partner/list";
	}
}


















