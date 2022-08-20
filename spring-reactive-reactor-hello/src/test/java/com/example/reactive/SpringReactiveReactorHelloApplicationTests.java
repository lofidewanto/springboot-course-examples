package com.example.reactive;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
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
		// Create a Flux that emits a sequence of random strings.
		Flux<String> dataStream = Flux.just("Java", "C++", "Python", "Ruby");

		// Subscribe to the Flux and print out each item.
		dataStream.log().subscribe(prog -> {
			System.out.println("Hello World " + prog);
		});
	}

	@Test
	void test_Hello_World_Mono() {
		// Create a Mono that emits an integer.
		Mono<Integer> dataStream = Mono.just(1);

		// Subscribe to the Mono and print out item.
		dataStream.log().subscribe(prog -> {
			System.out.println("Hello World " + prog);
		});
	}

	@Test
	void test_Hello_World_Mono_Error() {
		// Create a Mono that emits an integer.
		Mono<Integer> dataStream = Mono.error(new RuntimeException("Error"));

		// Subscribe to the Mono and print out item.
		dataStream.log().subscribe(prog -> {
			System.out.println("Hello World " + prog);
		}, error -> {
			System.out.println("Error " + error);
		});
	}

	@Test
	void test_Interface_Subscriber() {
		List<Integer> elements = new ArrayList<>();

		Flux.just(1, 2, 3, 4)
				.log()
				.subscribe(new Subscriber<Integer>() {
					@Override
					public void onSubscribe(Subscription s) {
						s.request(Long.MAX_VALUE);
					}

					@Override
					public void onNext(Integer integer) {
						elements.add(integer);
					}

					@Override
					public void onError(Throwable t) {
					}

					@Override
					public void onComplete() {
					}
				});

		assertEquals(elements.size(), 4);
	}

	@Test
	void test_Backpressure() {
		List<Integer> elements = new ArrayList<>();

		Flux.just(1, 2, 3, 4)
				.log()
				.subscribe(new Subscriber<Integer>() {

					private Subscription subscription;

					int onNextAmount;

					@Override
					public void onSubscribe(Subscription subscription) {
						this.subscription = subscription;
						subscription.request(2);
					}

					@Override
					public void onNext(Integer integer) {
						elements.add(integer);

						onNextAmount++;
						if (onNextAmount % 2 == 0) {
							subscription.request(2);
						}
					}

					@Override
					public void onError(Throwable t) {
					}

					@Override
					public void onComplete() {
					}
				});

		assertEquals(elements.size(), 4);
	}
}
