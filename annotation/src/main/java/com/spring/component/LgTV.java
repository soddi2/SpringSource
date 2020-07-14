package com.spring.component;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
 
@Component ("tv") //이름 설정 가능
public class LgTV implements TV {
	
	@Autowired //객체 주입
	@Qualifier("sonySpeaker")
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
