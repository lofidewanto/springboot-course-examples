package com.example.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calculator {

	private static final Logger logger = LoggerFactory.getLogger(Calculator.class);

	public int add(int x, int y) {
		int result = x + y;

		logger.info("Result: " + result);

		return result;
	}

}
