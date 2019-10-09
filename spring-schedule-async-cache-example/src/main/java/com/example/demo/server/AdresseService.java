package com.example.demo.server;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdresseService {

	private static final Logger logger = LoggerFactory.getLogger(AdresseService.class);

	@Autowired
	private PersonService personService;

	@Autowired
	private BookRepository bookRepository;

	public void callPerson() throws InterruptedException, ExecutionException {
		logger.info("Adresse.callPerson before");
		logger.info("Execute - " + Thread.currentThread().getName());

		CompletableFuture<String> result = personService.asyncMethodWithReturnType();

		result.thenAccept(output -> logger.info("Output: " + output));

		logger.info("Adresse.callPerson after");
	}

	public void getBooks() {
		logger.info(".... Fetching books");
		logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
		logger.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
		logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
		logger.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
		logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
		logger.info("isbn-1231 -->" + bookRepository.getByIsbn("isbn-1231"));
		logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
	}

}
