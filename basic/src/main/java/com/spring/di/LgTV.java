package com.spring.di;

public class LgTV implements TV {
	
	private Speaker speaker;
	private int price;
	

	public LgTV() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LgTV(Speaker speaker,int price) {
		super();
		this.speaker = speaker;
		this.price = price;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	@Override
	public void powerOn() {
		System.out.println("LGTV - 전원 On");
		System.out.println("스피커 가격 - "+price);
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
