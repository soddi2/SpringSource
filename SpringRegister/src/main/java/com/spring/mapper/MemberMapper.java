package com.spring.mapper;

import org.apache.ibatis.annotations.Param;

import com.spring.domain.AuthVO;
import com.spring.domain.LeaveVO;
import com.spring.domain.LoginVO;
import com.spring.domain.changePwdVO;

public interface MemberMapper {
	public AuthVO isLogin(LoginVO login);
	public String getupdate(String userid);
//	public String passwordupdate(@Param("userid") String userid, @Param("new_password") String new_password);
	public int passwordupdate(changePwdVO NWD); //@Param
	public int leave(LeaveVO leave);
}
