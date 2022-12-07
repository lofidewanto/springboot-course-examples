package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootTest
class HelloWorldApplicationTest {

	@Autowired
	Number number;

	@Autowired
	Number numberOne;

	@Autowired(required = false)
	Computer computer;

	@Autowired
	GenericApplicationContext applicationContext;

	@Test
	void context() {
	}

	@Test
	void number() throws Exception {
		number.numberCalculate();
		numberOne.numberCalculate();

		System.out.println("Number: " + number);
		System.out.println("NumberOne: " + numberOne);
	}

	@Test
	void compute() {
		applicationContext.registerBean(Computer.class, () -> new Computer());
		Computer computer = applicationContext.getBean(Computer.class);

		Calculator calculator = computer.getCalculator();

		System.out.println("Calculator: " + calculator);
	}

}
