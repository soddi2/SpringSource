package com.spring.stu;
public class StudentInfo {
	private Student student;
	
	public StudentInfo() {
		System.out.println("StudentInfo 객체 생성");
	}
	
	public StudentInfo(Student student) {
		this.student = student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public void getStudentInfo() {
		if(student!=null) {
			System.out.println("이름 : "+student.getName());
			System.out.println("나이 : "+student.getAge());
			System.out.println("반 : "+student.getClassNum());
		}
	}
}
