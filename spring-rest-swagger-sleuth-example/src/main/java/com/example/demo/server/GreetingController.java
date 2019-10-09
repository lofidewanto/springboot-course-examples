package com.example.demo.server;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

	private static final String template = "Hello, %s!";

	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private PersonService personService;

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name)
			throws InterruptedException {

		String hello = personService.hello();

		logger.info("Test " + hello);

		Thread.sleep(10000L);

		return new Greeting(counter.incrementAndGet(), String.format(template, hello));
	}
}