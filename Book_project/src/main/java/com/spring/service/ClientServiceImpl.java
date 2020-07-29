package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.ClientVO;
import com.spring.mapper.RegisterMapper;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private RegisterMapper mapper;

	@Override
	public boolean register(ClientVO vo) {
		
		return mapper.register(vo) > 0 ? true:false;
	}
	


}
