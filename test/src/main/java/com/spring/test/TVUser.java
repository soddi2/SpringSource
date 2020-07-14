package com.spring.test;

public class TVUser {
	public static void main(String[] args) {
		LgTV lg = new LgTV();
//		lg.powerOn();
//		lg.volumeUp();
//		lg.volumeDown();
//		lg.powerOff();
		
//		TV samsung = new LgTV(new SonySpeaker());
		SamsungTV tv = new SamsungTV();
		tv.setSpeaker(new SonySpeaker());
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	
	}
}
