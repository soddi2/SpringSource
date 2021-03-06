package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.AuthVO;
import com.spring.domain.LeaveVO;
import com.spring.domain.RegisterVO;
import com.spring.domain.changePwdVO;
import com.spring.service.MemberService;
import com.spring.service.RegisterService;
import com.spring.service.changPwdService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MemberRestController {

	@Autowired
	private MemberService Mservice;
	
	@Autowired
	private RegisterService Rservice;
	
	@Autowired
	private changPwdService Cservice;
	
	@PostMapping("/insert")
	public ResponseEntity<String> registerPost(RegisterVO vo) {
		log.info("회원 정보 입력"+vo);
		return Rservice.register(vo) ?
				 new ResponseEntity<String>("success",HttpStatus.OK) : 
				new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
	}
	
	// http://localhost:8080/register/step2 =>
	// http://localhost:8080/register/insert + post
	
//	@PostMapping("/insert")
//	public ResponseEntity<String> registerPost(@RequestBody RegisterVO vo) {
//		log.info("회원 정보 입력"+vo);
//		return Rservice.register(vo) ?
//				 new ResponseEntity<String>("success",HttpStatus.OK) : 
//				new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
//	}
	
	//http://localhost:8080/leave + delete
	@DeleteMapping("/leave")
	// @ResponseBody //json 정보 전달 , 자바 객체를 HTTP 요청의 body 내용으로 매핑하는 역할을 합니다.
	// @RequestBody : json 정보 받기 , HTTP 요청의 body 내용을 자바 객체로 매핑하는 역할을 합니다.
	public ResponseEntity<String> leaveDelete(@RequestBody LeaveVO leave,HttpSession session) {
		log.info("member정보 삭제 : "+leave);
		
		String cup = Cservice.getupdate(leave.getUserid());
		
		if(cup.equals(leave.getPassword())) {
			//일치한다면 삭제작업 시작
			if(Mservice.leave(leave)) {
				session.removeAttribute("auth");
				//삭제가 성공하면 세션 해제 인덱스 페이지로 이동
				return new ResponseEntity<String>("success",HttpStatus.OK);
			}else { //DB에러시
				//삭제 실패시 leave 페이지 보여주기
				return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
			}
		}
		return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/modify")
	public ResponseEntity<String> modify(@RequestBody changePwdVO modify,HttpSession session){
		
		AuthVO auth = (AuthVO) session.getAttribute("auth");
		
		log.info(""+auth);
		log.info("member 정보 수정 : "+modify);
		
		String np = modify.getPassword(); //확인할 비번(현재비번)		
		String cp = Cservice.getupdate(auth.getUserid()); //현재 비번
		boolean confirm = modify.newPasswordEqualsConfirm();
		
		if(cp.equals(np)) { //현재비번과 디비 비번이 같은지 확인
			modify.setUserid(auth.getUserid());
			if(confirm)
			{	
				if(Cservice.passwordupdate(modify)) {
					session.removeAttribute("auth");
					
					return new ResponseEntity<String>("success",HttpStatus.OK);
				}else {
					return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
				}
			}
		}
		return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);	
		
	}
}
























