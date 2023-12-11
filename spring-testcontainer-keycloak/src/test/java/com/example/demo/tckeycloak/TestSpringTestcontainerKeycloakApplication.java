package com.example.demo.tckeycloak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestSpringTestcontainerKeycloakApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpringTestcontainerKeycloakApplication::main).with(TestSpringTestcontainerKeycloakApplication.class).run(args);
	}

}
