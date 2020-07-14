package com.spring.di;

public class SamsungSpeaker implements Speaker {
	
	private Speaker speaker;

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
