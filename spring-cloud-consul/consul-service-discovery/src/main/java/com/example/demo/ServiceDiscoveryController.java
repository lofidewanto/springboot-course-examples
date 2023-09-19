package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceDiscoveryController {

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("/ping")
    public String ping() {
        return "pong: server";
    }

    @GetMapping("/health-check")
    public ResponseEntity<String> myCustomCheck() {
        String message = "Service Discovery: testing my healh check function";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
 
    @GetMapping("/info")
    public String getInfo() {
        return "{name: \"" + applicationName + "\" }";
    }

}
