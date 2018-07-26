package com.capgemini.jstk.boardbuddy.aop;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {


	private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Around("@annotation(logActivity)")
	public Object logActivity(ProceedingJoinPoint joinPoint, LogActivity logActivity) throws Throwable {
		Object proceed = joinPoint.proceed();
		logger.info("LOG at " + new Date() +" : " + logActivity.message());
		return proceed;
	}
	

}
