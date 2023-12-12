package com.example.demo.tckeycloak;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.net.URIBuilder;

import dasniko.testcontainers.keycloak.KeycloakContainer;
import io.restassured.RestAssured;
import jakarta.annotation.PostConstruct;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserControllerIT {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserControllerIT.class.getName());

    @LocalServerPort
    private int port;

    static final KeycloakContainer keycloak;

    static {
        keycloak = new KeycloakContainer().withRealmImportFile("realm-export.json");
        keycloak.start();
    }

    @PostConstruct
    public void init() {
        RestAssured.baseURI = "http://localhost:" + port;
    }

    @DynamicPropertySource
    static void registerResourceServerIssuerProperty(DynamicPropertyRegistry registry) {
        registry.add("spring.security.oauth2.resourceserver.jwt.issuer-uri",
                () -> keycloak.getAuthServerUrl() + "/realms/baeldung");
    }

    protected String getJaneDoeBearer() {
        try {
            URI authorizationURI = new URIBuilder(
                    keycloak.getAuthServerUrl() + "/realms/baeldung/protocol/openid-connect/token").build();
            WebClient webclient = WebClient.builder()
                    .build();
            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
            formData.put("grant_type", Collections.singletonList("password"));
            formData.put("client_id", Collections.singletonList("baeldung-api"));
            formData.put("username", Collections.singletonList("jane.doe@baeldung.com"));
            formData.put("password", Collections.singletonList("s3cr3t"));

            String result = webclient.post()
                    .uri(authorizationURI)
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .body(BodyInserters.fromFormData(formData))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            JacksonJsonParser jsonParser = new JacksonJsonParser();

            return "Bearer " + jsonParser.parseMap(result)
                    .get("access_token")
                    .toString();
        } catch (URISyntaxException e) {
            LOGGER.error("Can't obtain an access token from Keycloak!", e);
        }

        return null;
    }

    @Test
    void givenAuthenticatedUser_whenGetMe_shouldReturnMyInfo() {
        RestAssured.given().header("Authorization", getJaneDoeBearer())
                .when()
                .get("/users/me")
                .then()
                .body("username", Matchers.equalTo("janedoe"))
                .body("lastname", Matchers.equalTo("Doe"))
                .body("firstname", Matchers.equalTo("Jane"))
                .body("email", Matchers.equalTo("jane.doe@baeldung.com"));
    }
}