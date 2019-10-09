package com.example.demo.server;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdresseServiceTest {

	@Autowired
	private AdresseService adresseService;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetBooks() {
		adresseService.getBooks();
	}

}
