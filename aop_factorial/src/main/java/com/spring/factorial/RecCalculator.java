package com.spring.factorial;

import org.springframework.stereotype.Component;

@Component("rec")
public class RecCalculator implements Calculator {

	@Override
	public long factorial(long num) {
		//재귀로 구하는 factorial
		if(num==0) {
			return 1;
		}else {
			return num * factorial(num-1);
		}
	}

}
