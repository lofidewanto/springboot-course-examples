package com.example.demo.server;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class AdresseServiceTest {

	@Autowired
	private AdresseService adresseService;

	@BeforeEach
	public void setUp() throws Exception {
	}

	@Test
	public void testGetBooks() {
		adresseService.getBooks();
	}

}
