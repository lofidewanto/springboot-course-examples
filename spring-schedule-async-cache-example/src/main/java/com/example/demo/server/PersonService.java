package com.example.demo.server;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

	private static final Logger logger = LoggerFactory.getLogger(PersonService.class);

	@Async
	public void hello() throws InterruptedException {
		logger.info("Person.hello before");

		Thread.sleep(10000);

		logger.info("Person.hello after");
	}

	@Async
	public CompletableFuture<String> asyncMethodWithReturnType() throws InterruptedException {
		logger.info("Execute method asynchronously - " + Thread.currentThread().getName());

		Thread.sleep(5000);

		return CompletableFuture.completedFuture("Hello world complete!");
	}

}
