package com.spring.autowired;

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
