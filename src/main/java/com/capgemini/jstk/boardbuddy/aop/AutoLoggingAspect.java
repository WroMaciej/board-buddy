package com.capgemini.jstk.boardbuddy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AutoLoggingAspect {
	
	private final Logger LOGGER = LoggerFactory.getLogger(AutoLoggingAspect.class);
	
	@Pointcut("execution(public * com.capgemini.jstk.boardbuddy.dao.UserDaoFacade.findById(..))")
    private void findUserById(){}

	
	@Around("findUserById()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object output = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Found user id in: ");
		stringBuilder.append(elapsedTime);
		stringBuilder.append(" milliseconds.");
		LOGGER.info(stringBuilder.toString());
        return output;
    }

}
