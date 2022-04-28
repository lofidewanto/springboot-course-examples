package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

    public String getName() {
        return "My name is Calculator!";
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

}
