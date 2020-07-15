package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.PartnerVO;
import com.spring.mapper.PartnerMapper;

@Service //@Component,@Repository,@Controller => 객체생성
public class PartnerServiceImpl implements PartnerService {

	@Autowired //객체 주입 @inject
	private PartnerMapper mapper; // = new PartnerService()를 framwork가 해주는데 쓸꺼면 어노테이션 쓰고 쓰라고 함  
	
	@Override
	public boolean create(PartnerVO vo) {
		return mapper.create(vo) > 0 ? true:false;
	}

}
