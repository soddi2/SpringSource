package com.spring.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {

		System.out.println("IoC 컨테이너 구동 전");
		//스프링 컨테이너 구동하기 => 설정파일 읽기
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		System.out.println("컨테이너 구동 후");
		// Look Up : 스프링 컨테이너로부터 필요한 객체를 요청
		TV tv = (TV) ctx.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	
	}
}
