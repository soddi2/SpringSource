package com.spring.service;

import java.util.List;

import com.spring.domain.PersonVO;

public interface PersonService {
	public void insertPerson(String id,String name);
	public String selectPerson(String id);
	public List<PersonVO> getList();
	public boolean updatePerson(PersonVO vo);
	public boolean deletePerson(String id);
}
