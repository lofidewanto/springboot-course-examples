package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.example.demo.util.Multiplicator;

@Configuration
@ImportResource("classpath:application-context.xml")
@Import(Multiplicator.class)
public class AppConfig {

}
