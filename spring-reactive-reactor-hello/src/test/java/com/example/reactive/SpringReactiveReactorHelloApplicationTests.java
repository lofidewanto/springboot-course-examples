package com.example.reactive;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
class SpringReactiveReactorHelloApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void test_Hello_World_Flux() {
		// Create a Flux that emits a sequence of random integers.
		Flux<String> dataStream = Flux.just("Java", "C++", "Python", "Ruby");

		// Subscribe to the Flux and print out each item.
		dataStream.subscribe(prog -> {
			System.out.println("Hello World " + prog);
		});
	}

	@Test
	void test_Hello_World_Mono() {
		// Create a Flux that emits a sequence of random integers.
		Mono<Integer> dataStream = Mono.just(1);

		// Subscribe to the Flux and print out each item.
		dataStream.subscribe(prog -> {
			System.out.println("Hello World " + prog);
		});
	}

}
