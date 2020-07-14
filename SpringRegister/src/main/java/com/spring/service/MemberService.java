package com.spring.service;

import com.spring.domain.AuthVO;
import com.spring.domain.LeaveVO;
import com.spring.domain.LoginVO;

public interface MemberService {
	public AuthVO isLogin(LoginVO login);
	public boolean leave(LeaveVO leave);
}
