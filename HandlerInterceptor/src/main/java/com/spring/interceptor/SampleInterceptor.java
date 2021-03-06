package com.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SampleInterceptor extends HandlerInterceptorAdapter {
	
	//pre에서 넘어온 요청 검토
	//컨트롤러 동작이 다 끝나고 난 후에 작동
	//ModelAndView(model and view 예전 컨트롤러 리턴 방식)
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("post Handle");
	}
	
	
	//doa로 오는 요청 검토
	//컨트롤러 가기전에 먼저 들어감
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception { 
		System.out.println("pre Handle");
		return true; //true면 넘어가고 false면 작업이 pre에서 멈춤
	}
}
