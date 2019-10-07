package com.example.demo.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.config.AppConfig;

@SpringBootApplication(scanBasePackageClasses = AppConfig.class)
public class SpringAppcontextExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAppcontextExampleApplication.class, args);
	}

}
