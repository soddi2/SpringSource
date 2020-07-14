package com.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductMain {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		Product pro = (Product) ctx.getBean("product");
		pro.setCompany("다이소");
		pro.setPname("다이소 바나나");
		pro.setPrice("1000");
		pro.getInfo();
	}
}
