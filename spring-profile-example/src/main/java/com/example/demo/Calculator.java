package com.example.demo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class Calculator {

	public int add(int x, int y) {
		return x + y;
	}

}
