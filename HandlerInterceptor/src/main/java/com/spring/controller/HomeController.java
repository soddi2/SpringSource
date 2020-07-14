package com.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@GetMapping("/doA")
	public void doA() throws Exception { 
		logger.info("doA 요청");
		throw new Exception("강제 익셉션");
	}
	
	@GetMapping("/doB")
	public void doB() { 
		logger.info("doB 요청");
	}
	
	@GetMapping("/doC")
	public ModelAndView doC() {
		logger.info("doC 요청");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("test", "ModelAndView"); //=> model에 값 담기
		mav.setViewName("result"); // => 보여줄 jsp 이름
		return mav;
	}
	
}















