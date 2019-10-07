package com.example.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Divider {

	private static final Logger logger = LoggerFactory.getLogger(Divider.class);

	public int divide(int x, int y) {
		int result = x / y;

		logger.info("Result: " + result);

		return result;
	}

}
