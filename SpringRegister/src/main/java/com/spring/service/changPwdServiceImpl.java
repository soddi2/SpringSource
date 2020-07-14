package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.changePwdVO;
import com.spring.mapper.MemberMapper;

@Service
public class changPwdServiceImpl implements changPwdService {

	@Autowired
	private MemberMapper mapper;
	
	@Override
	public boolean passwordupdate(changePwdVO NWD) {
		return mapper.passwordupdate(NWD) == 1 ? true:false;
	}

	@Override
	public String getupdate(String userid) {
		return mapper.getupdate(userid);
	}

}
