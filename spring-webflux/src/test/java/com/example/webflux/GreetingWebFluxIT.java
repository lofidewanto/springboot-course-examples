package com.example.webflux;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@Disabled
@SpringBootTest
public class GreetingWebFluxIT {

    @Bean
    WebClient webClient() {
        return WebClient.create();
    }

    @Test
    void test_real_server() {
        WebClient.ResponseSpec responseSpec = webClient().get()
                .uri("http://localhost:8080/hello")
                .retrieve();

        String response = responseSpec.bodyToMono(String.class).block();

        assertThat(response).isEqualTo("{\"content\":\"Hello, Spring WebFlux!\"}");
    }

}
