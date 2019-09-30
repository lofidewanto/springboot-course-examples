package com.example.demo.server.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.demo.server.entity.Input;

@Validated
@Service
public class ValidationService {

	public void validateInput(@Valid Input input) {
		// Doing something...
	}

}
