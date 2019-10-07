package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.util.Divider;

@Configuration
public class DividerConfig {

	@Bean
	public Divider divider() {
		return new Divider();
	}
}
