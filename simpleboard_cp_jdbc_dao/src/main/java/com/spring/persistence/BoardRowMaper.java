package com.spring.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.domain.BoardVO;

public class BoardRowMaper implements RowMapper<BoardVO> {

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO vo = new BoardVO();
		vo.setBno(rs.getInt("bno"));
		vo.setTitle(rs.getString("title"));
		vo.setWriter(rs.getString("writer"));
		vo.setContent(rs.getString("content"));
		vo.setRegdate(rs.getDate("regdate"));
		vo.setUpdatedate(rs.getDate("updatedate"));
		
		return vo;
	}

}
