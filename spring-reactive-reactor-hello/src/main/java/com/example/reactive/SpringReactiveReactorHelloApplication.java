package com.example.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringReactiveReactorHelloApplication {

	public static void main(String[] args) {
		// Create a Flux that emits a sequence of random integers.
		Flux<String> dataStream = Flux.just("Java", "C++", "Python", "Ruby");

		SpringApplication.run(SpringReactiveReactorHelloApplication.class, args);

		// Subscribe to the Flux and print out each item.
		dataStream.subscribe(prog -> {
			System.out.println("Hello Word " + prog);

		});
	}

}
