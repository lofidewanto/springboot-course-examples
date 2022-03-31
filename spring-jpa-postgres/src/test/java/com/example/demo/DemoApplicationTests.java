package com.example.demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Disabled("This test is disabled because it requires a running PostgreSQL container")
@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
