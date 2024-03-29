package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.spring.domain.SampleVO;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController  //리턴값을 마음대로 전송할 수 있음 
//@Controller
public class RestControllerTest {

	@GetMapping(value="/hello",produces = "text/plain;charset=utf-8")
	public String sayHello() {
		return "Hello"; 
	}	
	
	@GetMapping("/sendVO")
	public SampleVO sendVO() {
		SampleVO sample = new SampleVO();
		sample.setMno("1234");
		sample.setFirstName("hong");
		sample.setLastName("Dong");
		
		return sample;
	}
	
	@GetMapping(value="/sendlist",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SampleVO> sendList() {
		
		List<SampleVO> list = new ArrayList<SampleVO>();
		
		for(int i=0;i<10;i++) {
			SampleVO sample = new SampleVO();
			sample.setMno(String.valueOf(i));
			sample.setFirstName("hong"+i);
			sample.setLastName("Dong"+i);
			list.add(sample);
		}
		return list;
	}
	
	// ResponseEntity : 데이터 +Http 상태 코드
	// 다양한 형태의 데이터와 상태코드를 같이 담아서 보낼때 사용
	
	@GetMapping("/check") //http://localhost:8080/check?height=149&weight=48
	public ResponseEntity<SampleVO> check(double height,double weight){
		SampleVO vo =  new SampleVO();
		vo.setMno("123");
		vo.setFirstName(height+"");
		vo.setLastName(weight+"");
		
		ResponseEntity<SampleVO> entity = null;
		if(height <150) {
			// 400 : HttpStatus.BAD_REQUEST
			entity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(vo); //상태코드 지정 : 150 이하일 경우 BAD_REQUEST로 network단에 빨게짐
		}else {
			// 200 : HttpStatus.OK
			entity = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		return entity;
	}
	
	// http://localhost:8080/product/bags/1234
	// http://localhost:8080/product/shoes/1234
	// http://localhost:8080/product/T-shirt/1234
	
	//특정 parameter값을 페이지 전환하면서 유지를 해야 할 경우
	//경로에 들어오는 값을 변수에 담아서 처리
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat,@PathVariable("pid") String pid) {
		return new String[] {"category : "+cat, "productId : "+pid};  
	}
}
























