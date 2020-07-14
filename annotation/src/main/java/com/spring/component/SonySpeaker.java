package com.spring.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //객체 생성 해줭
public class SonySpeaker implements Speaker {

	private Speaker speaker;

	public SonySpeaker() {
		System.out.println("SonySpeaker() 객체생성");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("SonySpeaker --소리 올리기");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("SonySpeaker --소리 내리기");
	
	}

}
