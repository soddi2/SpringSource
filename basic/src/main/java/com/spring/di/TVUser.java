package com.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {

		System.out.println("IoC 컨테이너 구동 전");
		//스프링 컨테이너 구동하기 => 설정파일 읽기
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		System.out.println("컨테이너 구동 후");
		// Look Up : 스프링 컨테이너로부터 필요한 객체를 요청
		TV tv = (TV) ctx.getBean("tv2");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	
//		TV tv2 = (TV) ctx.getBean("tv3"); //getbean = lookup (있는걸 찾는 거)
//		//싱글톤 : 객체를 하나만 생성해서 쓰는 방식(스프링)
//		if(tv==tv2) {
//			System.out.println("tv == tv2");
//		}else {
//			System.out.println("tv != tv2");
//		}
	}
}
