package com.example.redisdemo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import redis.embedded.RedisServer;
import redis.embedded.RedisServerBuilder;

@SpringBootTest
@ActiveProfiles({ "test" })
public class SpringDataRedisDemoApplicationTests {
    
    private static RedisServer redisServer;
    
    @BeforeAll
    public static void startRedisServer() {
        redisServer = new RedisServerBuilder().port(6379).setting("maxmemory 256M").build();
        redisServer.start();
    }

    @AfterAll
    public static void stopRedisServer() {
        redisServer.stop();
    }
    
    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}