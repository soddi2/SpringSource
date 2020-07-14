package com.spring.client;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.MemberVO;
import com.spring.service.MemberService;

public class MemberClient {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		MemberService service = (MemberService) ctx.getBean("member");
		
		List<MemberVO> list = service.getList();
		for(MemberVO vo:list) {
			System.out.println(vo);
		}
		
	}
}
