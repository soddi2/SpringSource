package com.spring.test;

public class LgTV implements TV {
	
	private Speaker speaker;
	
	public LgTV() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LgTV(Speaker speaker) {
		super();
		this.speaker = speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	@Override
	public void powerOn() {
		System.out.println("LGTV - 전원 On");
		
	}
	@Override
	public void powerOff() {
		System.out.println("LGTV - 전원 Off");
	}
		
	@Override
	public void volumeUp() {
		//System.out.println("LGTV - 볼륨 Up");
		speaker.volumeUp();
		
	}
	@Override
	public void volumeDown() {
		//System.out.println("LGTV - 볼륨 Down");
		speaker.volumeDown();
	}
}
