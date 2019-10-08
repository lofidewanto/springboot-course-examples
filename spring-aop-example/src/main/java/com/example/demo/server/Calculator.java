package com.example.demo.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Calculator {

	private static final Logger logger = LoggerFactory.getLogger(Calculator.class);

	public int add(int x, int y) {
		logger.info("Object Id: " + this);

		int ergebnis = x + y;

		return ergebnis;
	}

}
