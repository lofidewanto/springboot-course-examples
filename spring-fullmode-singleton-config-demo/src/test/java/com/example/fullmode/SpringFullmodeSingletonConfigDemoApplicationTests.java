package com.example.fullmode;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringFullmodeSingletonConfigDemoApplicationTests {

	@Autowired
	ClientService clientService1;

	@Autowired
	ClientService clientService2;

	@Test
	void contextLoads() {
		clientService1.runClientDao();
		clientService2.runClientDao();
	}

}
