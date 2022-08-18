package com.example.redisdemo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
public class RedisMessageListenerIT {

    static {
        GenericContainer<?> redis = new GenericContainer<>(DockerImageName.parse("redis:5.0.3-alpine"))
                .withExposedPorts(6379)
                .withCommand("redis-server --requirepass mypass");
        redis.start();
        System.setProperty("spring.redis.host", redis.getHost());
        System.setProperty("spring.redis.port", redis.getMappedPort(6379).toString());
    }
    
    @Autowired
    RedisMessagePublisher redisMessagePublisher;

    @AfterAll
    public static void setEnvs() {
        // Set the props back to the properties values
        System.setProperty("spring.redis.host", "localhost");
        System.setProperty("spring.redis.port", "6379");
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