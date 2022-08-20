package com.example.webflux;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringWebfluxApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Test
	void contextLoads() {
	}

	@Test
	void test_hello() {
		webTestClient
				// Create a GET request to test an endpoint
				.get().uri("/hello")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				// ... and use the dedicated DSL to test assertions against the response
				.expectStatus().isOk()
				.expectBody(Greeting.class).value(greeting -> {
					assertThat(greeting.getContent()).isEqualTo("Hello, Spring WebFlux!");
				});
	}

	@Test
	void test_hello_as_only_is_OK() {
		webTestClient
				// Create a GET request to test an endpoint
				.get().uri("/hello")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				// ... and use the dedicated DSL to test assertions against the response
				.expectStatus().isOk();
	}

}
