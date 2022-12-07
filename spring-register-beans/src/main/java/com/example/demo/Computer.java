package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class Computer {

    private static final Logger logger = LoggerFactory.getLogger(Computer.class);
    
    @Autowired(required = true)
    private Calculator calculator;

    public void compute() {
        logger.info("Calculator: " + calculator);

        calculator.calculate();
        
        logger.info("Compute");
    }

    public Calculator getCalculator() {
        return this.calculator;
    }
}
