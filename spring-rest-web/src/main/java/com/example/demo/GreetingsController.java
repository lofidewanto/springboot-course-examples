package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    private Logger logger = LoggerFactory.getLogger(GreetingsController.class);
    
    @GetMapping("/greetings/{name}")
    public String greet(@PathVariable String name) {
        logger.debug("test");

        return "Hello " + name;
    }
}
