package com.spring.mapper;

import java.util.List;

import com.spring.domain.PartnerVO;

public interface PartnerMapper {
	public List<PartnerVO> read();
	public int register(PartnerVO vo);
}
