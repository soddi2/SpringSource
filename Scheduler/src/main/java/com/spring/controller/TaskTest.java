package com.spring.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component //객체생성(@Service, @Controller, @Repository)
public class TaskTest {
	
	//@Scheduled : 메소드에 붙여주는 어노테이션 메소드는 void 형태이고 파라미터를 갖지 않아야 함 
	//			   cron에 사용하는 스케쥴링 방식을 가지고 있음 사용가능한 value는 cronm fixeDelay, fixedRate 등 존재
	
	//cron : 유닉스 계열의 컴퓨터 운용 체제의 시간 기반 잡 스케쥴러 
	
	@Scheduled(cron = "0 * * * * *")
	public void schedulerTest() {
		System.out.println("매 분 1초마다 스케쥴링 테스트 중.....");
	}
	
	@Scheduled(fixedDelay = 10000)
	public void schedulerTest2() {
		System.out.println("10초마다 스케쥴링 테스트 중....");
	}
}
