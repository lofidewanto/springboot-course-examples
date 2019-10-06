package com.example.demo.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;

@SpringBootApplication
public class SpringConversionExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConversionExampleApplication.class, args);
	}

	@Bean
	public ConversionService conversionService() {
		ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
		bean.afterPropertiesSet();
		return bean.getObject();
	}

}
