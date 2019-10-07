package com.example.demo.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.config.AppConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppConfig.class)
public class CalculatorTest {

	private static final Logger logger = LoggerFactory.getLogger(CalculatorTest.class);

	@Autowired
	private Calculator calculator;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		int add = calculator.add(10, 11);

		logger.info(Integer.toString(add));

		assertThat(add).isEqualTo(21);
	}

}
