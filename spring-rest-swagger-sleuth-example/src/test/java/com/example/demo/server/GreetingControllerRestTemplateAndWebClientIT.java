package com.example.demo.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GreetingControllerRestTemplateAndWebClientIT {

	private static final Logger logger = LoggerFactory.getLogger(GreetingControllerRestTemplateAndWebClientIT.class);

	@Test
	public void test_With_RestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		Greeting greeting = restTemplate.getForObject("http://localhost:8080/greeting", Greeting.class);
		logger.info(greeting.getContent());
	}

	@Test
	public void test_With_WebClient() {
		WebClient client = WebClient.create("http://localhost:8080");

		Mono<ClientResponse> result = client.get().uri("/greeting").accept(MediaType.APPLICATION_JSON).exchange();

		// logger.info(">> result = " + result.flatMap(res ->
		// res.bodyToMono(Greeting.class)).block());

		result.subscribe(ergebnis -> logger.info(ergebnis.toString()));
	}

}
