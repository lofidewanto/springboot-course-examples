package com.example.demo.server;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	@Pointcut("execution(* com.example.demo.server.*.*(..))")
	public void allMethods() {
	}

	@Around("allMethods()")
	public Object adviceBeanAllMethodsLogging(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("Before: " + pjp.toString());

		Object result = pjp.proceed();

		logger.info("After: " + pjp.toString());

		return result;
	}
}
