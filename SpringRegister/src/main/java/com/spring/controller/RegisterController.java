package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.RegisterVO;
import com.spring.service.RegisterService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/register/*")
public class RegisterController {
	
	@Autowired
	private RegisterService service;
	
	@GetMapping("/step1")
	public void step1() {
		log.info("step1 페이지 요청");
		
	}
	
	//주소창에 주소를 넣어 바로 이동 가능
//	@GetMapping("/step2")
//	public void step2() { 
//		log.info("step2 페이지 요청");
//		
//	}
	
//	@PostMapping("/step2")
//	public void stepPost() { //abigious 겹치는 이름이 있음 안되용
//		log.info("step2 페이지 요청");
//		
//	}
	
	@PostMapping("/step2")
	public String handleStep2(boolean agree,RedirectAttributes rttr) {
		log.info("step2 페이지 보여주기"+agree);
		//agree 체크 여부에 따라서 체크가 안된 경우
		//step1 페이지를 다시 보여주기
		
		//값을 보내줄때 넘길 준비
		/* model.addAttribute("agree", agree); */
		
		if(!agree) {
			rttr.addFlashAttribute("msg", false); //flash는 el로 바로 꺼내 쓸수 있어서 편함
			return "redirect:step1"; //실패
		}
		return "/register/step2"; //성공				
	}
	
	@PostMapping("/step3")
	public String step3(@ModelAttribute("vo") RegisterVO vo,Model model) {
		//step2.jsp에서 사용자의 입력값 가져오기
		log.info(""+vo);
		log.info("userid "+vo.getUserid());
		log.info("password "+vo.getPassword());
		log.info("confirm_password "+vo.getConfirm_password());
		log.info("username "+vo.getName());
		log.info("gender "+vo.getGender());
		log.info("email "+vo.getEmail());
		
		if(vo.isPasswordEqualToConfirmPassword()) {
			//step3.jsp 보여주기
			//session에 담는거랑 비슷함 다음페이지에서도 사용할때 데이터 전달
			model.addAttribute("userid", vo.getUserid());
			model.addAttribute("password", vo.getPassword());
			model.addAttribute("confirm_password", vo.getConfirm_password());
			model.addAttribute("username", vo.getName());
			model.addAttribute("gender", vo.getGender());
			model.addAttribute("email", vo.getEmail());
			
			if(service.register(vo)) {
				log.info("회원가입 성공");
				return "/register/step3";
			}else {
				return "/register/step2";
			}
		}else {
			//회원가입 페이지로 돌려보내기 
			//포워드 방식
			return "register/step2";
		}		
	}
	
	@GetMapping(value= {"/step2","/step3"})
	public String handleStep2_3() {
		//사용자가 step2,step3를 get 방식으로 요청하는 경우에 step1으로 되돌려 보내기
		//샌드리다이랙트
		return "redirect:step1";
	}
	
	@PostMapping("/checkId")
	@ResponseBody //내가 던지는 값이 jsp값이 아닌 그냥 데이터 값으로 넘긴다, 컨트롤러에서 던지는 값이 jsp값이 아님을 의미
	public String checkId(String userid) {
		log.info("중복 아이디 검사 : "+userid);
		if(service.checkId(userid)) {
			return "true";
		}else {
			return "false";
		}
	}
}
















