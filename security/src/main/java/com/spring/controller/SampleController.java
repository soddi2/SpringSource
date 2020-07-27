package com.spring.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SampleController {
	
	/* 시큐리티 어노테이션
	 *  @Secured() : 문자열 배열 형식으로 표현
	 *  @PreAuthorize(#user.name == princcipal.name) : 표현식 이용
	 *  @PostAuthorize(hasAnyRole(여러권한들....) : 표현식 이용
	 * 
	 */


//	@Secured({"ROLE_MEMBER","ROLE_ADMIN"})
	@PreAuthorize("hasAnyRole('ROLE_MEMBER','ROLE_ADMIN')")
	@GetMapping("/anno_member")
	public void doMember1() {
		log.info("어노테이션 설정 - 로그인 멤버만 가능");
	}
	
//	@Secured("ROLE_ADMIN")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/anno_admin")
	public void doAdmin() {
		log.info("어노테이션 설정 - 관리자만 가능");
	}
	
}













