package com.example.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Multiplicator {

	private static final Logger logger = LoggerFactory.getLogger(Multiplicator.class);

	public int multiply(int x, int y) {
		int result = x * y;

		logger.info("Result: " + result);

		return result;
	}

}
