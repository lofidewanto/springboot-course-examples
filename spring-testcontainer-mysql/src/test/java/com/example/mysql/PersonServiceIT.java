package com.example.mysql;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Disabled("This test is disabled because it requires a running MySQL container")
@ActiveProfiles("dev")
@Transactional
@SpringBootTest
public class PersonServiceIT {

    @Autowired
    private PersonService personService;

    @Autowired
    private Flyway flyway;

    @BeforeEach
    void setUp() {
        flyway.clean();
        flyway.migrate();
    }

    @Test
    void run_flyway() {
        assertNotNull(personService);
    }

    @Test
    void create_person() {
        // Prepare
        Person person = new Person("Hans", "Cologne", 42);

        // CUT
        Person createAddressFromPerson = personService.createPerson(person);

        // Asserts
        assertNotNull(createAddressFromPerson);
    }

}
