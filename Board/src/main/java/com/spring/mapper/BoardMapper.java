package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;

public interface BoardMapper {
	public List<BoardVO> list(Criteria cri);
	public int total(Criteria cri);
	public int register(BoardVO register);
	public BoardVO read(BoardVO read);
	public int modify(BoardVO modify);
	public int delete(int bno);
	public int updateReplyCnt(@Param("bno") int bno,@Param("amount") int amount);
}
