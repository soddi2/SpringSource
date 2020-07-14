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

import com.spring.domain.MemberVO;

@Repository
public class MemberDAO {
	
	@Autowired
	private DataSource ds;
	
	//회원 목록
	//유저 목록 가져오기
		public List<MemberVO> getList(){
			List<MemberVO> list = new ArrayList<MemberVO>();
			String sql = "select * from member";
			
			try(Connection con = ds.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)) {
				
					ResultSet rs = pstmt.executeQuery();
					while(rs.next()) {
						MemberVO vo = new MemberVO();
						vo.setUserid(rs.getString("userid"));
						vo.setPassword(rs.getString("password"));
						vo.setName(rs.getString("name"));
						vo.setGender(rs.getString("gender"));
						vo.setEmail(rs.getString("email"));
						list.add(vo);
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
	
	//로그인 처리
	public MemberVO isLogin(String userid,String password) {
		String sql = "select userid,name from member where userid = ? and password = ?";
		try(Connection con = ds.getConnection();
				PreparedStatement pstmt= con.prepareStatement(sql);) {	
				pstmt.setString(1, userid);
				pstmt.setString(2, password);
				
				ResultSet rs = pstmt.executeQuery();	
	
				if(rs.next()){ 
				MemberVO vo = new MemberVO();
				vo.setUserid(rs.getString(1));
				vo.setName(rs.getString(2));
				return vo;
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return null;
	}

}






















