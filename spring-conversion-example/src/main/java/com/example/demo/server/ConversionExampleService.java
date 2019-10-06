package com.example.demo.server;

import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@Component
public class ConversionExampleService {

	private ConversionService conversionService;

	public ConversionExampleService(ConversionService conversionService) {
		this.conversionService = conversionService;
	}

	public int convertInteger(String intAsString) {
		Integer convert = conversionService.convert(intAsString, Integer.class);
		return convert;
	}

}
