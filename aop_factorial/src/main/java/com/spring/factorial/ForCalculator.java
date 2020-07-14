package com.spring.factorial;

import org.springframework.stereotype.Component;

@Component("forc")
public class ForCalculator implements Calculator {

	@Override
	public long factorial(long num) {
		//for문으로 구하는 팩토리얼
		long result = 1;
		
		for(int i = 1; i<=num; i++) {
			result*=i; //5! = 5*4*3*2*1
		}
		return result;
	}

}
