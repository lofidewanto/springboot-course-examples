package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("dev")
@SpringBootTest
class SpringProfileExampleApplicationTests {

	@Autowired
	Calculator calculator;

	@Autowired
	TaschenRechner taschenRechner;

	@Test
	void contextLoads() {
	}

	@Test
	void test_Rechner_Calculator() {
		int add1 = calculator.add(10, 1);

		System.out.println("Result Calculator: " + add1);

		int add2 = taschenRechner.add(11, 13);

		System.out.println("Result Taschenrechner: " + add2);
	}

}
