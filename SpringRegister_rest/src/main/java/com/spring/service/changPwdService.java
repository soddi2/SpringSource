package com.spring.service;

import com.spring.domain.changePwdVO;

public interface changPwdService {
	//비번 추출
	public String getupdate(String userid);
	
	//비번 변경
	public boolean passwordupdate(changePwdVO NWD);
}
