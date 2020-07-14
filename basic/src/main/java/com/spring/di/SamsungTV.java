package com.spring.di;

public class SamsungTV implements TV {
	private Speaker speaker;
	private int price;
	
	public void setPrice(int price) {
		this.price = price;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	@Override
	public void powerOn() {
		System.out.println("Samsung - 전원 On");
		System.out.println("스피커 가격 - "+price);
	}
	@Override
	public void powerOff() {
		System.out.println("Samsung - 전원 Off");
	}
	@Override
	public void volumeUp() {
		//System.out.println("Samsung - 볼륨 Up");
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
		//System.out.println("Samsung - 볼륨 Down");
		speaker.volumeDown();
	}
	
	
	
}
