package com.example.demo.server;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringAopExampleApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(SpringAopExampleApplication.class);

	@Autowired
	Calculator calculator;

	@Test
	void contextLoads() {
	}

	@Test
	void logging_aspect_test() {
		int add = calculator.add(10, 20);

		logger.info("Result: " + add);

		assertEquals(30, add);
	}

}
