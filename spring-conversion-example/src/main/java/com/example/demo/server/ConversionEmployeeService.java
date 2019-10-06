package com.example.demo.server;

import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@Component
public class ConversionEmployeeService {

	private ConversionService conversionService;

	public ConversionEmployeeService(ConversionService conversionService) {
		this.conversionService = conversionService;
	}

	public Employee convertEmployee(String employeeAsString) {
		Employee employee = conversionService.convert(employeeAsString, Employee.class);
		return employee;
	}

}
