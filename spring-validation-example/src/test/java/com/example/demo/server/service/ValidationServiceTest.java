package com.example.demo.server.service;

import javax.validation.ConstraintViolationException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.server.entity.Input;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidationServiceTest {

	@Autowired
	private ValidationService validationService;

	@Before
	public void setUp() throws Exception {
	}

	@Test(expected = ConstraintViolationException.class)
	public void testValidateInput_whenNumber_NotValid_thenThrowsException() {
		Input input = new Input();
		input.setNumberBetweenOneAndTen(11);

		validationService.validateInput(input);
	}

	@Test
	public void testValidateInput_whenNumber_Valid_thenSuccess() {
		Input input = new Input();
		input.setNumberBetweenOneAndTen(10);

		validationService.validateInput(input);
	}

	@Test
	public void testValidateInput_whenIp_Valid_thenSuccess() {
		Input input = new Input();
		input.setIpAddress("192.168.178.1");
		input.setNumberBetweenOneAndTen(10);

		validationService.validateInput(input);
	}

	@Test(expected = ConstraintViolationException.class)
	public void testValidateInput_whenIp_NotValid_thenThrowsException() {
		Input input = new Input();
		input.setIpAddress("122.121.123.1.0");
		input.setNumberBetweenOneAndTen(10);

		validationService.validateInput(input);
	}

	@Test
	public void testFindByCode_whenCode_Valid_thenSuccess() {
		validationService.findByCode("Test Lofi");
	}

	@Test(expected = ConstraintViolationException.class)
	public void testFindByCode_whenCode_NotValid_thenThrowsException() {
		validationService.findByCode("Test");
	}

}
