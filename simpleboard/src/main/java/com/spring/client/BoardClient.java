package com.spring.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.spring.domain.BoardVO;
import com.spring.service.Boardservice;

@Component
public class BoardClient {

	public static void main(String[] args) {
		//컨테이너 구동
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		//Lookup
		Boardservice service = (Boardservice) ctx.getBean("board");
		
//		//게시글 등록
//		BoardVO vo =  new BoardVO();
//		vo.setTitle("스트링 게시판");
//		vo.setContent("스프링 게시판 연습");
//		vo.setWriter("안유성");
//		int result = service.insertBoard(vo);
//		if(result>0) {
//			System.out.println("입력성공");
//		}else {
//			System.out.println("입력실패");
//		}
//	}
		
		//게시글 전체 리스트 가져오기
		List<BoardVO> list = service.getList();
		for(BoardVO vo:list) {
			System.out.println(vo);
		}
	}
}







