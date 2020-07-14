package com.spring.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.service.SampleService;

public class SampleClient {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		SampleService service = (SampleService) ctx.getBean("sample");
		
		String data = "starry/r/n"+"starry night/r/n"+"paint your paletter blue and gray/r/n"+"Look out on a summer`day";

		service.addData(data);
		
		
	}

}
