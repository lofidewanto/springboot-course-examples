package com.example.demo.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class CalculatorApplicationContextXmlTest {

	private ApplicationContext applicationContext;

	@Test
	public void testClassPathXml() {
		applicationContext = new ClassPathXmlApplicationContext("application-context.xml");

		Calculator calculatorBean = applicationContext.getBean(Calculator.class);
		int add = calculatorBean.add(10, 20);

		assertThat(add).isEqualTo(30);
	}

	@Test
	public void testFileXml() {
		applicationContext = new FileSystemXmlApplicationContext("classpath:application-context.xml");

		Calculator calculatorBean = applicationContext.getBean(Calculator.class);
		int add = calculatorBean.add(10, 20);

		assertThat(add).isEqualTo(30);
	}

}
