package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.PartnerVO;
import com.spring.mapper.PartnerMapper;

@Service
public class PartnerServiceImpl implements PartnerService {
	
	@Autowired
	private PartnerMapper mapper;

	@Override
	public List<PartnerVO> read() {
		return mapper.read();
	}

	@Override
	public boolean register(PartnerVO vo) {
		return mapper.register(vo) > 0 ? true:false;
	}
}
