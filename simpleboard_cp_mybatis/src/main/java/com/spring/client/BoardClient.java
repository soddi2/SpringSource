package com.spring.client;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.BoardVO;
import com.spring.service.Boardservice;

public class BoardClient {
	public static void main(String[] args) {
		//컨테이너 구동
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("config.xml");
		//Lookup
		Boardservice service = (Boardservice) ctx.getBean("board");
		
		//게시글 등록
//		BoardVO vo = new BoardVO();
//		vo.setTitle("스프링 게시판22");
//		vo.setContent("스프링 게시판 연습22");
//		vo.setWriter("홍길동2");
//		int result=service.insertBoard(vo);
//		if(result>0) {
//			System.out.println("입력성공");
//		}else {
//			System.out.println("입력실패");
//		}
		
		//게시글 전체 리스트 가져오기
		List<BoardVO> list = service.getList();
		for(BoardVO vo1:list) {
			System.out.println(vo1);
		}
		
		//수정
//		BoardVO vo = new BoardVO();
//		vo.setBno(22);
//		vo.setTitle("이거시 게시판이다");
//		vo.setContent("마이배티스 게시판");
//		int result=service.updateBoard(vo);
//		if(result>0) {
//			System.out.println("입력성공");
//		}else {
//			System.out.println("입력실패");
//		}
		
		//삭제
//		int result=service.deleteBoard(23);
//		if(result>0) {
//			System.out.println("입력성공");
//		}else {
//			System.out.println("입력실패");
//		}
	
		//하나만 보기
//		BoardVO vo = service.getBoard(21);
//		System.out.println(vo);
	}
}














