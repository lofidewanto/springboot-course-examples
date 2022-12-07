package com.example.demo;

import org.junit.jupiter.api.Test;

public class NumberTest {

    @Test
    void number() throws Exception {
        Calculator calculator = new Calculator();
        Number number = new Number(calculator);

        number.numberCalculate();
    }
    
}
