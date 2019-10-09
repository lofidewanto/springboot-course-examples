package com.example.demo.server;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
public class SimpleBookRepository implements BookRepository {

	@Cacheable("books")
	@Override
	public Book getByIsbn(String isbn) {
		simulateSlowService();
		return new Book(isbn, "Some book");
	}

	private void simulateSlowService() {
		try {
			Thread.sleep(8000L);
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}

}