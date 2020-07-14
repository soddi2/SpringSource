package com.spring.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import domain.BookVO;

public class BookRowMaper implements RowMapper<BookVO> {

	@Override
	public BookVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BookVO vo = new BookVO();
		vo.setCode(rs.getString("code"));
		vo.setPrice(rs.getInt("price"));
		vo.setTitle(rs.getString("title"));
		vo.setWriter(rs.getString("writer"));
		return vo;
	}

}
