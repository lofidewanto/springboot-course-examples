package com.example.demo.server;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

@SpringBootApplication
public class SpringConversionExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConversionExampleApplication.class, args);
	}

	@Bean
	public ConversionService conversionService() {
		ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();

		// For Custom Converter
		Set<Converter<?, ?>> converters = new HashSet<>();
		converters.add(stringToEmployeeConverter());
		bean.setConverters(converters);

		bean.afterPropertiesSet();
		return bean.getObject();
	}

	@Bean
	public StringToEmployeeConverter stringToEmployeeConverter() {
		return new StringToEmployeeConverter();
	}

}
