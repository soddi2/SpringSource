package com.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.domain.LoginVO;
import com.spring.domain.RegisterVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller	//객체생성
@RequestMapping("/member") //주소를 맵핑
public class MemberController {

	//get이 포스트 보다 우선
	//post는 반드시 명시를 해야함 405에러
//	@RequestMapping(value="/login",method=RequestMethod.POST)
//	@PostMapping("/login")
//	@PutMapping("/login") == @PatchMapping("/login")
//	@DeleteMapping("/login")
	
	@GetMapping("/login") // http://localhost:8080/member/login get방식
	public void login() {
		log.info("login 폼 요청");
	}
	
//	@PostMapping("/login") // http://localhost:8080/member/login post방식
//	public void loginPost(HttpServletRequest req) { //잘 안슴
//		log.info("로그인 요청");
//		
//		//사용자가 보낸 값 가져오기
//		log.info("userid:"+req.getParameter("userid"));
//		log.info("password:"+req.getParameter("password"));
//		
//	}
	
//	@PostMapping("/login") // http://localhost:8080/member/login post방식
//	public void loginPost(@RequestParam("userid")String id,String password) { //변수명이 동일 이름이 동일하지만 나는 이건 파라미터로 넘어오는 값이다 라고 할때 어노테이션을 씀
//		log.info("로그인 요청");
//		
//		//사용자가 보낸 값 가져오기
//		log.info("userid:"+id);
//		log.info("password:"+password);
//		
//	}
	
	@PostMapping("/login") // http://localhost:8080/member/login post방식
	public String loginPost(@ModelAttribute("vo") LoginVO login,Model model) { //vo에 담기 되게 유용함
		log.info("로그인 요청");
		
		//사용자가 보낸 값 가져오기
		log.info("userid:"+login.getUserid());
		log.info("password:"+login.getPassword());
		
		//logout.jsp 보여주기
		//request.setAttribute("test",arr); 과 같은 의미 (forword)
		
//		model.addAttribute("userid", login.getUserid());
//		model.addAttribute("password", login.getPassword());
		
		return "member/logout";
	}
	
	@RequestMapping("/logout")
	public void logout() {
		log.info("logout 요청");
	}
	
	@RequestMapping("/register")
	public void register() {
		log.info("register 폼 요청");
	}
	
	@PostMapping("/register")
	public void registerPost(RegisterVO vo) {
		log.info("register 요청");
		
		//사용자가 보낸 값 가져오기
		log.info("userid:"+vo.getUserid());
		log.info("password:"+vo.getPassword());
		log.info("confirm_password:"+vo.getConfirm_password());
		log.info("mobile:"+vo.getMobile());
	}
	
	@GetMapping("/update")
	public void update() {
		log.info("update 폼 요청");
	}
	
//	@PostMapping("/update")
//	public void updatePost(String userid,String password,Model model) { //다음작업을 할때 억지로 담음
//		log.info("update 요청");
////		log.info("userid:"+vo.getUserid());
////		log.info("password:"+vo.getPassword());
//		
//		model.addAttribute("userid", userid);
//		model.addAttribute("password", password);
//	}
	
	@PostMapping("/update")
	public void updatePost(@ModelAttribute("userid") String userid,String password) { 
		log.info("update 요청");
//		log.info("userid:"+vo.getUserid());
//		log.info("password:"+vo.getPassword());
	}
	
	//@ModelAttribute : 1.도메인 객체의 이름 지정
	//					2.Model의 역할을 함
}









