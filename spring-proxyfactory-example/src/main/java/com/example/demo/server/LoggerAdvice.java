package com.example.demo.server;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

@Component("loggerAdvice")
public class LoggerAdvice implements MethodBeforeAdvice {

	private static final Logger logger = LoggerFactory.getLogger(LoggerAdvice.class);

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		logger.info("Executing Target: " + target + " - Method; " + method);
	}

}
