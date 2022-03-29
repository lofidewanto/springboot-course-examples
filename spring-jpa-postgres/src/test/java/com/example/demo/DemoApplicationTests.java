package com.example.demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Disabled("We need to have Postgres running for this test to work")
@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
