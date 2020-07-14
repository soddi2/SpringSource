package com.spring.log;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j //롬복 어노테이션 설정
public class LogTest {
	
	//private static final Logger logger=LoggerFactory.getLogger(LogTest.class);
	
	public static void main(String[] args) {
		log.error("error 레벨");
		log.error("warn 레벨");
		log.error("info 레벨");
		log.error("debug 레벨");
		log.error("trace 레벨");
		//logger.error("error 레벨");
		//logger.warn("warn 레벨");
		//logger.info("info 레벨");
		//logger.debug("debug 레벨");
		//logger.trace("trace 레벨");
	}
	
}
