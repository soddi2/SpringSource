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
import org.springframework.stereotype.Repository;

import domain.BookVO;

@Repository
public class BookDAO {
		
	@Autowired
	private DataSource ds;
	
	//유저 목록 가져오기
	public List<BookVO> getList(){
		List<BookVO> list = new ArrayList<BookVO>();
		String sql = "select * from bookTBL";
		
		try(Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					BookVO vo = new BookVO();
					vo.setCode(rs.getString("code"));
					vo.setTitle(rs.getString("title"));
					vo.setWriter(rs.getString("writer"));
					vo.setPrice(rs.getInt("price"));
					list.add(vo);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
	























