package com.spring.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import domain.BookVO;

@Repository
public class BookDAO {
		
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String BOARD_INSERT = "insert into bookTBL(code,title,writer,price) values(?,?,?,?)";
	private final String BOARD_LIST = "select * from bookTBL";
	private final String BOARD_GET = "select * from bookTBL where code=?";
	private final String BOARD_UPDATE = "update bookTBL set price=? where code=?";
	private final String BOARD_DELETE = "delete from bookTBL where code=?";
	
	//유저 목록 가져오기
	public List<BookVO> getList(){
		System.out.println("=> 유저 목록 <=");
		
		return jdbcTemplate.query(BOARD_LIST, new BookRowMaper());
	}
	
	//게시글 등록
	public int insertArticle(BookVO vo) {
		System.out.println("=> 글 등록 <=");
		int result = jdbcTemplate.update(BOARD_INSERT,
				vo.getCode(),
				vo.getTitle(),
				vo.getWriter(),
				vo.getPrice()
				);
		
		return result;
	}
	
	//게시글 수정
	public int updateArticle(BookVO vo) {
		System.out.println("=> 목록 수정 <=");
		
		return jdbcTemplate.update(BOARD_UPDATE,
				vo.getCode(),
				vo.getTitle(),
				vo.getWriter(),
				vo.getPrice()
				);	
	}
	
	//게시글 삭제
		public int deleteArticle(String code) {
			System.out.println("==> 스프링 제이디비씨 삭제 처리");
			return jdbcTemplate.update(BOARD_DELETE, code);
		}
		
		//게시글 하나 가져오기
		public BookVO getRow(String code) {
			System.out.println("==> 스프링 제이디비씨 셀렉트 처리");
			Object args[] = {code};
			return jdbcTemplate.queryForObject(BOARD_GET, args, new BookRowMaper());
		}
	
}
	























