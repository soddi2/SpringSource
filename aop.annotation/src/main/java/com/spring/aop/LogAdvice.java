package com.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("log")
@Aspect
public class LogAdvice {
	
//	@Before(value="execution(* com.spring.aop.Product.getInfo())")
//	public void beforeLog() {
//		System.out.println("[공통로그] 비즈니스 로직 수행 (전)انا 호출");
//	}
	
//	@After(value="execution(* com.spring.aop.Product.getInfo())")
//	public void afterLog() {
//		System.out.println("[공통로그] 비즈니스 로직 수행 بعد(후) 호출");
//	}
	
//	@AfterReturning(value="execution(* com.spring.aop.Product.getInfo())")
//	public void afterReturnLog() {
//		System.out.println("[공통로그] 비즈니스 로직 정상수행 بعد(후) 호출");
//	}
	
//	@AfterThrowing(value="execution(* com.spring.aop.Product.getInfo())")
//	public void afterThrowingLog() {
//		System.out.println("[공통로그] 비즈니스 로직 예외사항이 발생할 때 수행 بعد(후) 호출");
//	}
	
	@Around(value="execution(* com.spring.aop.Product.getInfo())")
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






















