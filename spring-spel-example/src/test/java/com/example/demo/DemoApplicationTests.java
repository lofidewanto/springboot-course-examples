package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private PersonalService personalService;

	@Test
	void contextLoads() {
	}

	@Test
	void personalService_with_SpEL() {
		String personalInfo = personalService.getPersonalInfo("Lofi");

		assertEquals("Hello, Lofi! My name is Calculator!", personalInfo);
	}

}
