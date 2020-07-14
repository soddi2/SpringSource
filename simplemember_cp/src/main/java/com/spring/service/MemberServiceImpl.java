package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.MemberVO;
import com.spring.persistence.MemberDAO;

@Service("member")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO dao;
	
	@Override
	public MemberVO isLogin(String userid, String password) {
		return dao.isLogin(userid, password);
	}

	@Override
	public boolean password(String userid, String new_password, String current_password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean passwordupdate(String userid, String new_password, String current_password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean register(MemberVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean leave(String userid, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MemberVO> getList() {
		// TODO Auto-generated method stub
		return dao.getList();
	}

}
