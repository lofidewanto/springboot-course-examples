package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(HelloWorldApplication.class);

	@Autowired
	Calculator calculator;

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Test CommandLine...");

		calculator.calculate();

		logger.info("Ende");
	}

}
