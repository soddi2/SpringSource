package com.spring.di;

public class MessageBean {
	private String name;
	private String greeting;
	
	public MessageBean(String name, String greeting) {
		super();
		this.name = name;
		this.greeting = greeting;
	}

	public void sayHello() {
		System.out.println(greeting+", "+name);
	}
}
