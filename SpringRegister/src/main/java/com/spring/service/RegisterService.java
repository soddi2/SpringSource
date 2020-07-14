package com.spring.service;

import com.spring.domain.RegisterVO;

public interface RegisterService {
	public boolean register(RegisterVO vo);
	public boolean checkId(String userid);
	
}
