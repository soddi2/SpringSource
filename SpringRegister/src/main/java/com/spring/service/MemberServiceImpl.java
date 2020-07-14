package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.AuthVO;
import com.spring.domain.LeaveVO;
import com.spring.domain.LoginVO;
import com.spring.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper mapper;
	
	@Override
	public AuthVO isLogin(LoginVO login) {
		return mapper.isLogin(login);
	}

	@Override
	public boolean leave(LeaveVO leave) {
		return mapper.leave(leave) == 1 ? true:false;
	}

}
