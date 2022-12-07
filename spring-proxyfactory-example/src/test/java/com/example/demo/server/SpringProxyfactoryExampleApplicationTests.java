package com.example.demo.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.Advised;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringProxyfactoryExampleApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(SpringProxyfactoryExampleApplicationTests.class);

	@Autowired
	private Calculator calculator;

	@Test
	public void contextLoads() throws Exception {
		logger.info("Calculator class:" + calculator.getClass());
        Object target = ((Advised)calculator).getTargetSource().getTarget();;
        logger.info("Target class: " + target);

		int add = calculator.add(10, 10);

		logger.info("Result: " + add);
	}

}
