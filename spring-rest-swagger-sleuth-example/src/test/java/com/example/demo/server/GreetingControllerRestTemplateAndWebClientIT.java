package com.example.demo.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GreetingControllerRestTemplateAndWebClientIT {

	private static final Logger logger = LoggerFactory.getLogger(GreetingControllerRestTemplateAndWebClientIT.class);

	@LocalServerPort
	private int port;

	@Test
	public void test_With_RestTemplate() {
		RestTemplate restTemplate = new RestTemplate();

		logger.info("RestTemplate starts...");

		Greeting greeting = restTemplate.getForObject("http://localhost:" + port + "/greeting", Greeting.class);

		logger.info("RestTemplate result: " + greeting.getContent());

		logger.info("RestTemplate done...");
	}

	@Test
	public void test_With_WebClient_Blocking() {
		WebClient client = WebClient.create("http://localhost:" + port);

		Mono<ClientResponse> response = client.get().uri("/greeting").accept(MediaType.APPLICATION_JSON).exchange();

		logger.info("WebClient starts...");

		// Blocking WebClient
		logger.info("WebClient result = "
				+ response.flatMap(result -> result.bodyToMono(Greeting.class)).block().getContent());

		logger.info("WebClient done...");
	}

	@Test
	public void test_With_WebClient_Blocking_Retrieve() {
		WebClient client = WebClient.create("http://localhost:" + port);

		Mono<Greeting> greeting = client.get().uri("/greeting").accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(Greeting.class);

		logger.info("WebClient starts...");

		// Blocking WebClient
		logger.info("WebClient result = " + greeting.block().getContent());

		logger.info("WebClient done...");
	}

	@Test
	public void test_With_WebClient_NonBlocking() throws InterruptedException {
		WebClient client = WebClient.create("http://localhost:" + port);

		Mono<Greeting> greeting = client.get().uri("/greeting").accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(Greeting.class);

		logger.info("WebClient starts...");

		// Non blocking WebClient
		greeting.subscribe(ergebnis -> logger.info("WebClient result: " + ergebnis.getContent()));

		logger.info("WebClient done...");

		// Waiting for the result...
		Thread.sleep(12000L);
	}

}
