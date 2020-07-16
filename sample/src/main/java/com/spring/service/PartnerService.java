package com.spring.service;

import java.util.List;

import com.spring.domain.PartnerVO;

public interface PartnerService {
	public boolean create(PartnerVO vo);
	public List<PartnerVO> read();
}
