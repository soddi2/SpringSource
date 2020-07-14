package com.spring.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component ("samsung")
public class SamsungSpeaker implements Speaker {
	
	private Speaker speaker;

	public SamsungSpeaker(Speaker speaker) {
		super();
		this.speaker = speaker;
	}

	public SamsungSpeaker() {
		System.out.println("SamsungSpeaker() 객체생성");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("SamsungSpeaker --소리 올리기");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("SamsungSpeaker --소리 내리기");
	
	}

}
