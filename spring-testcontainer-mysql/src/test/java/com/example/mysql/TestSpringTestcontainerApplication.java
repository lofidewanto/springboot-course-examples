package com.example.mysql;

import org.springframework.boot.SpringApplication;

public class TestSpringTestcontainerApplication {

    public static void main(String[] args) {
        SpringApplication.from(Application::main).with(TestcontainersConfiguration.class).run(args);
    }

}
