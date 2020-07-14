package com.spring.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.spring.domain.PersonVO;

public interface PersonMapper {
	
//	@Insert("insert into person(id,name) values(#{id},#{name})")
//	public int insertPerson(@Param("id") String id,
//								@Param("name") String name);
	
	//xml 설정방식
	public int insertPerson(@Param("id") String id,@Param("name") String name);
	
	public String selectPerson(String id);

	public List<PersonVO> selectPersons();
	
	public int updatePerson(PersonVO vo);
	
	public int deletePerson(String id);
}




















