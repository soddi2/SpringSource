package com.spring.stu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentMain {
	public static void main(String[] args) {
//		StudentInfo info1 = new StudentInfo(new Student("안유성", "25", "1"));
//		info1.getStudentInfo();
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config2.xml");
		
		StudentInfo info = (StudentInfo) ctx.getBean("info");
		info.getStudentInfo();
	}
}
