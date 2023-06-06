package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TaschenRechner {

	@Value("${test.profile.name}")
	String testProfileName;

	public int add(int x, int y) {
		System.out.println("Name: " + testProfileName);

		return x + y;
	}

}
