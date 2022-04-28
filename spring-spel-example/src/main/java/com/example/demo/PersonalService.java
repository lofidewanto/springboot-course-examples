package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PersonalService {

    @Value("#{calculator.name}")
    private String name;

    public String getPersonalInfo(String name) {
        return "Hello, " + name + "! " + this.name;
    }
    
}
