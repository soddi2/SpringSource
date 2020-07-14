package com.spring.autowired;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class LgTV implements TV {
	
	//@Autowired //생성된거 중에 하나 주입해 주세요 -활성화 코드가 필요함
	@Qualifier("samsung") //주입할 대상의 객체가 여러개 라면
	@Inject
	private Speaker speaker;
	
	public LgTV() {
		super();
		// TODO Auto-generated constructor stub
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
