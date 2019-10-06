package com.example.demo.server;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConversionEmployeeServiceTest {

	@Autowired
	private ConversionEmployeeService conversionEmployeeService;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testConvertEmployee() {
		Employee actualEmployee = new Employee(1, 50000.00);

		assertThat(conversionEmployeeService.convertEmployee("1,50000.00"))
				.isEqualToComparingFieldByField(actualEmployee);
	}

}
