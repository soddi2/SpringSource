package com.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		//MessageBean msg = new MessageBean();
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		MessageBean msg = (MessageBean) ctx.getBean("msg2");
		
		msg.sayHello();

	}

}
