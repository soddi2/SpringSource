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

import com.spring.domain.BoardVO;

//@Component
@Repository
public class BoardDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;	
	
	private final String BOARD_INSERT = "insert into spring_board(bno,title,content,writer) values(seq_board.nextVal,?,?,?)";
	private final String BOARD_LIST = "select * from spring_board";
	private final String BOARD_GET = "select * from spring_board where bno=?";
	private final String BOARD_UPDATE = "update spring_board set title=?, content=? where bno=?";
	private final String BOARD_DELETE = "delete from spring_board where bno=?";
	
	//게시글 등록
	public int insertArticle(BoardVO vo) {
		System.out.println("==> Spring JDBC INSERT 처리");
		int result = jdbcTemplate.update(BOARD_INSERT, 
				vo.getTitle(),
				vo.getContent(),
				vo.getWriter());
		
		return result;
	}
	
	//게시글 전체 가져오기
	public List<BoardVO> getList(){
		System.out.println("==> Spring JDBC SELECT 처리");
		
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMaper());
	}
	
	//게시글 수정
	public int updateArticle(BoardVO vo) {
		System.out.println("==> 스프링 제이디비씨 수정 처리");
		
		return jdbcTemplate.update(BOARD_UPDATE, 
				vo.getTitle(),
				vo.getContent(),
				vo.getBno()
				
				);
	}
	
	//게시글 삭제
	public int deleteArticle(BoardVO vo) {
		System.out.println("==> 스프링 제이디비씨 삭제 처리");
		return jdbcTemplate.update(BOARD_DELETE, vo.getBno());
	}
	
	//게시글 하나 가져오기
	public BoardVO getRow(int bno) {
		System.out.println("==> 스프링 제이디비씨 셀렉트 처리");
		Object args[] = {bno};
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMaper());
	}
}








