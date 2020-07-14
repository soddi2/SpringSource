package com.spring.service;

import java.util.List;

import com.spring.domain.PartnerVO;

public interface PartnerService {
	public List<PartnerVO> read();
	public boolean register(PartnerVO vo);
}
