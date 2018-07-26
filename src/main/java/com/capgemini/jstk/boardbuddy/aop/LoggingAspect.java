package com.capgemini.jstk.boardbuddy.aop;

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
	
	@Around("@annotation(LogActivity)")
	public Object logActivity(ProceedingJoinPoint joinPoint) throws Throwable {
		Object proceed = joinPoint.proceed();
		logger.info("Logger logs fine.");
		return proceed;
	}

}
