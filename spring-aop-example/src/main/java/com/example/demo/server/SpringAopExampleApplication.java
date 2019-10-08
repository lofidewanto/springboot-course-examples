package com.example.demo.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAopExampleApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(SpringAopExampleApplication.class);

	@Autowired
	private Calculator calculator;

	public static void main(String[] args) {
		SpringApplication.run(SpringAopExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int add = calculator.add(10, 10);

		logger.info("Result: " + add);
	}

}
