package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.PersonVO;
import com.spring.mapper.PersonMapper;

@Service("person")
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonMapper mapper;
	
	@Override
	public void insertPerson(String id, String name) {
		
		System.out.println(mapper.insertPerson(id, name)==0?"실패":"성공");
		
	}
	
	@Override
	public String selectPerson(String id) {
		
		return mapper.selectPerson(id);
	}
	
	@Override
	public List<PersonVO> getList() {
		return mapper.selectPersons();
	}
	
	@Override
	public boolean updatePerson(PersonVO vo) {
		
		return mapper.updatePerson(vo)==1?true:false;
	}
	
	@Override
	public boolean deletePerson(String id) {
		return mapper.deletePerson(id)==1?true:false;
	}
	
}








