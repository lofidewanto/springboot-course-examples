package com.example.demo.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.config.MultiplicatorConfig;

public class CalculatorApplicationContextCombinationTest {

	private static final Logger logger = LoggerFactory.getLogger(CalculatorApplicationContextCombinationTest.class);

	private ApplicationContext xmlApplicationContext;

	private ApplicationContext annotationApplicationContext;

	@Test
	public void testClassPathXmlAndAnnotation() {
		testAnnotation();
		testXml();
	}

	private void testXml() {
		xmlApplicationContext = new ClassPathXmlApplicationContext("application-context.xml");

		Calculator calculatorBean = xmlApplicationContext.getBean(Calculator.class);
		int add = calculatorBean.add(10, 20);

		assertThat(add).isEqualTo(30);

		for (String beanDefinitionName : xmlApplicationContext.getBeanDefinitionNames()) {
			logger.info("XML: " + beanDefinitionName);
		}
	}

	private void testAnnotation() {
		annotationApplicationContext = new AnnotationConfigApplicationContext(MultiplicatorConfig.class);

		Multiplicator multiplicatorBean = annotationApplicationContext.getBean(Multiplicator.class);
		int multiply = multiplicatorBean.multiply(10, 20);

		assertThat(multiply).isEqualTo(200);

		for (String beanDefinitionName : annotationApplicationContext.getBeanDefinitionNames()) {
			logger.info("Annotation: " + beanDefinitionName);
		}
	}

}
