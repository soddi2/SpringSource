package com.spring.service;

import java.util.List;

import com.spring.domain.MemberVO;

public interface MemberService {
	public List<MemberVO> getList();
	public MemberVO isLogin(String userid,String password);
	public boolean password(String userid,String new_password,String current_password);
	public boolean passwordupdate(String userid,String new_password,String current_password);
	public boolean register(MemberVO vo);
	public boolean leave(String userid,String password);
}
