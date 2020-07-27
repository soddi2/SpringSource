package com.spring.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

//테스트 클래스  - public / 인자를 받지 않는 생성자를 제공해야 함
@RunWith(SpringJUnit4ClassRunner.class) //현재 테스트 코드가 스프링을 실행할거야
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security.xml"}) //테스트코드를 실행할 때 필요한 환경설정 파일 지정
@Slf4j
public class MemberTest {
	
	@Autowired
	private PasswordEncoder encoder;	
	@Autowired
	private DataSource ds;
	
	//테스트 메소드 - @Test 어노테이션 / public, 파라미터는 없어야 하고, void 
	@Test
	public void test() {
		log.info("테스트 메소드 호출");
		String sql = "insert into spring_member(userid,userpw,username) values(?,?,?)";
		
		for(int i=0;i<100;i++) { //100명의 사용자 생성
		
			try(Connection con = ds.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)) {
					pstmt.setString(2, encoder.encode("pw"+i));
					
					if(i < 80) { //80명 일반 회원
						pstmt.setString(1, "user"+i);
						pstmt.setString(3, "일반회원"+i);
					}else if(i < 90) {
						pstmt.setString(1, "manager"+i);
						pstmt.setString(3, "운영자"+i);
					}else {
						pstmt.setString(1, "admin"+i);
						pstmt.setString(3, "관리자"+i);
					}
					pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}











