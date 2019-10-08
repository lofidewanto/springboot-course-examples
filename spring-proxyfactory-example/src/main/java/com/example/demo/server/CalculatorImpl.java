package com.example.demo.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalculatorImpl implements Calculator {

	private static final Logger logger = LoggerFactory.getLogger(CalculatorImpl.class);

	@Override
	public int add(int x, int y) {
		logger.info("Object Id: " + this);

		int ergebnis = x + y;

		return ergebnis;
	}

}
