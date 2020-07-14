package com.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component("log")
public class LogAdvice {
	public void beforeLog() {
		System.out.println("[공통로그] 비즈니스 로직 수행 (전)انا 호출");
	}
	
	public void afterLog() {
		System.out.println("[공통로그] 비즈니스 로직 수행 بعد(후) 호출");
	}
	
	public void afterReturnLog() {
		System.out.println("[공통로그] 비즈니스 로직 정상수행 بعد(후) 호출");
	}
	
	public void afterThrowingLog() {
		System.out.println("[공통로그] 비즈니스 로직 예외사항이 발생할 때 수행 بعد(후) 호출");
	}
	
	public void aroundLog(ProceedingJoinPoint pjp) {
		System.out.println("[공통로그] 비즈니스 로직 수행 전 후 호출");
		
		try {
			pjp.proceed(); //실제 수행할 비즈니스 메소드를 호출
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("[공통로그] 비즈니스 로직 수행 후 호출");
	}
	
}






















