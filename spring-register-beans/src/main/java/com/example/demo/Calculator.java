package com.example.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;

public class Calculator {
    
    private static final Logger logger = LoggerFactory.getLogger(Calculator.class);
    
    @Cacheable("addresses")
    public void calculate() {
        logger.info("Test Calc");
    }

    public void initCalculator() {
        logger.info("INIT");
    }

    public void destroyCalculator() {
        logger.info("DESTROY");
    }

    @PostConstruct
    public void postConstruct() {
        logger.info("*** POST CONSTRUCT");
    }

    @PreDestroy
    public void preDestroy() {
        logger.info("*** PRE DESTROY");
    }
}
