package com.spring.test;

public class SamsungTV implements TV {
	private Speaker speaker;

	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	@Override
	public void powerOn() {
		System.out.println("Samsung - 전원 On");
	}
	@Override
	public void powerOff() {
		System.out.println("Samsung - 전원 Off");
	}
	@Override
	public void volumeUp() {
		System.out.println("Samsung - 볼륨 Up");
	}
	@Override
	public void volumeDown() {
		System.out.println("Samsung - 볼륨 Down");
	}
	
}
