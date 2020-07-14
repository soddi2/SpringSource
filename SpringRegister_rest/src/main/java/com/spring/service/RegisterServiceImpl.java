package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.AuthVO;
import com.spring.domain.LoginVO;
import com.spring.domain.RegisterVO;
import com.spring.mapper.RegisterMapper;

@Service("register")
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	private RegisterMapper mapper;

	@Override
	public boolean register(RegisterVO vo) {
		
		return mapper.register(vo) > 0 ? true:false;
	}

	@Override
	public boolean checkId(String userid) { 
		return mapper.checkId(userid) > 0 ? false:true; //1이 넘어와서 못쓰는 상황이라
	}
}
