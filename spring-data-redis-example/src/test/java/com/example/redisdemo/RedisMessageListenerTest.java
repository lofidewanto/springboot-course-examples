package com.example.redisdemo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import redis.embedded.RedisServer;
import redis.embedded.RedisServerBuilder;

@SpringBootTest
@ActiveProfiles({ "test" })
public class RedisMessageListenerTest {

    static RedisServer redisServer;

    @Autowired
    RedisMessagePublisher redisMessagePublisher;

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
    public void testOnMessage() throws Exception {
        RedisMessageListener.messageList.clear();

        String message = "Message " + UUID.randomUUID();
        redisMessagePublisher.publish(message);

        Thread.sleep(10000);

        assertTrue(RedisMessageListener.messageList.get(0).contains(message));
    }
}