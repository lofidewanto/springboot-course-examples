package com.example.mysql;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PersonRepositoryIT {

    @Container
    static MySQLContainer<?> database = new MySQLContainer<>("mysql:8.4")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test");

    @DynamicPropertySource
    static void setDatasourceProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", database::getJdbcUrl);
        registry.add("spring.datasource.username", database::getUsername);
        registry.add("spring.datasource.password", database::getPassword);
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "validate");
        registry.add("spring.flyway.enabled", () -> "true");
        registry.add("spring.flyway.url", database::getJdbcUrl);
        registry.add("spring.flyway.user", database::getUsername);
        registry.add("spring.flyway.password", database::getPassword);
    }

    @Autowired
    private PersonRepository personRepository;

    @Test
    void should_return_persons() {
        // Given
        Person person = new Person("Hans", "Berlin", 43);
        Person savedPerson = personRepository.save(person);
        assertNotNull(savedPerson.getId());

        // When
        List<Person> persons = personRepository.findAll();

        // Then
        // One inserted via migration FlyWay + one via this test
        assertEquals(2, persons.size());
        Person foundPerson = persons.getLast();
        assertEquals("Hans", foundPerson.getName());
        assertEquals("Berlin", foundPerson.getAddress());
        assertEquals(43, foundPerson.getAge());
    }
}
