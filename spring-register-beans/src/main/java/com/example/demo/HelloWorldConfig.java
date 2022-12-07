package com.example.demo;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class HelloWorldConfig {

    @Bean
    public Calculator calculator() {
        return new Calculator();
    } 
    
}
