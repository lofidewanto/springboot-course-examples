package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.Advised;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Number {

    private static final Logger logger = LoggerFactory.getLogger(Number.class);
    
    private Calculator calculator;

    private Integer count = 0;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired(required = false)
    public Number(Calculator calculator) {
        this.calculator = calculator;
    }

    public void numberCalculate() throws Exception {
        logger.info("Calculator class: " + calculator.getClass());

        if (!calculator.getClass().equals(Calculator.class)) {
            Object target = ((Advised) calculator).getTargetSource().getTarget();

            logger.info("Target class: " + target);
        }

        calculator.calculate();

        count = count + 1;

        logger.info("Calculator: " + calculator);
        logger.info("Count" + count);
    }
}
