package com.spring.mybatis;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.PersonVO;
import com.spring.service.PersonService;


public class PersonClient {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		PersonService ps = (PersonService) ctx.getBean("person");
		
//		ps.insertPerson("ccc", "박재희");
//		System.out.println(ps.selectPerson("aaa"));
//		List<PersonVO> list = ps.getList();
//		for(PersonVO vo:list) {
//			System.out.println(vo);
//		}
		
		//업데이트
		PersonVO vo = new PersonVO();
		vo.setId("ccc");
		vo.setName("소머리국밥");
		if(ps.updatePerson(vo)) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		//삭제
		ps.deletePerson("aaa");
		List<PersonVO> list = ps.getList();
		for(PersonVO vo1:list) {
			System.out.println(vo1);
		}
		
	}

}
















