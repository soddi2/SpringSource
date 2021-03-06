package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.AuthVO;
import com.spring.domain.LeaveVO;
import com.spring.domain.LoginVO;
import com.spring.domain.RegisterVO;
import com.spring.domain.changePwdVO;
import com.spring.service.MemberService;
import com.spring.service.RegisterService;
import com.spring.service.changPwdService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private changPwdService service2;
	
	//로그인
	@GetMapping("/login")
	public void login() {
		log.info("로그인 폼 요청");
	}
	
	//로그인 처리
	@PostMapping("/login")
	public String loginPost(@ModelAttribute("login") LoginVO login,HttpSession session) {
		//login.jsp에서 넘긴 값 가져오기
		log.info(""+login);
		//로그인 확인 => 성공시 index.jsp / 실패시 로그인 페이지
		AuthVO auth = service.isLogin(login);
		
		if(auth!=null) {
			//세션에 값 담기
			session.setAttribute("auth", auth);
			return "redirect:/"; //주소가 바뀌니까?
		}else {
			return "/member/login";			
		}			
	}
	
	//로그아웃 => 세션 해체 후 인덱스 페이지 보여주기
	@GetMapping("/logout") // http://localhost:8080/member/logout
	public String logout(HttpSession session) {
		log.info("로그아웃");
		//세션에 있는 모든 정보 삭제
		session.invalidate();
		//세션에 있는 특정한 정보 삭제
//		session.removeAttribute("auth");
		
		return "redirect:/";
	}
	
	//비밀번호 변경
	//jsp => /member/changePwd
	@GetMapping("/changePwd") //버튼을 눌러서 들어가면 get 맵핑 (바로가기)
	public void changePwd() {
		log.info("비밀번호 변경");
	}
	
	@PostMapping("/changePwd")
	public String changePwdPost(changePwdVO change,HttpSession session,AuthVO vo,RedirectAttributes rttr,boolean agree) {
		//changPwd에서 넘겨온 값 받기
		//userid 알아내기
		vo = (AuthVO) session.getAttribute("auth");
		
		log.info(""+change);
		log.info(""+vo);
		
		//userid와 일치하는 비밀번호 추출
		//사용자가 입력한 현재 비밀번호와 일치하는지 확인
		
		String np = change.getPassword(); //확인할 비번
		String cp = service2.getupdate(vo.getUserid()); //현재 비번
		
		//일치한다면 수정작업 시작
		 if(cp.equals(np)) {
			 //userid 담아주기
			 change.setUserid(vo.getUserid());
			 if(service2.passwordupdate(change)) {
				 //수정작업이 성공하면 세션해제 후 로그인 페이지로 이동
				 session.removeAttribute("auth");
				 rttr.addFlashAttribute("info", "비번 변경 성공");
			
				 return "redirect:/";
			 }else {
				 
				 //비밀 번호 변경 실패
				 rttr.addFlashAttribute("error", "두개의 비번 불일치 ");
				 return "redirect:/member/changePwd";
			 }
		 }else {
			 //현재 비밀번호가 일치하지 않을때
			 rttr.addFlashAttribute("error", "현재 비번 확인");
			 return "redirect:/member/changePwd";
		 }
	}
	
	//회원탈퇴 버튼을 클릭시 leave 보여주기
	@GetMapping("/leave")
	public void leaveform() {
		log.info("탈퇴 페이지 보여주기");
	}
	
	//회원 탈퇴
	@PostMapping("/leave") //변화를 줄때 post
	public String leavePost(AuthVO auth,HttpSession session,LeaveVO leave,RedirectAttributes rttr) {
		
		log.info(""+leave);
		
		//auth = (AuthVO) session.getAttribute("auth");

		//DB에서 userid가 넘겨져 옴
		//userid와 일치하는 비밀번호 추출
		//select password where userid = leave.getUserid()
		String cup = service2.getupdate(leave.getUserid());
		
		if(cup.equals(leave.getPassword())) {
			//일치한다면 삭제작업 시작
			if(service.leave(leave)) {
				session.removeAttribute("auth");
				rttr.addFlashAttribute("info", "탈퇴 성공");
				//삭제가 성공하면 세션 해제 인덱스 페이지로 이동
				return "redirect:/";				
			}else { //DB에러시
				//삭제 실패시 leave 페이지 보여주기
				rttr.addFlashAttribute("error", "탈퇴 실패");
				return "redirect:/member/leave";
			}
		}
		rttr.addFlashAttribute("error", "탈퇴 실패");
		return "redirect:/member/leave";
	}
}
















