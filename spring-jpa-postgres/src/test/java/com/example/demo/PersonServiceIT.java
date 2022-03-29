package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Disabled("We need to have Postgres running for this test to work")
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
	void testFlyway() {
		assertNotNull(personService);
	}
    
    @Test
	void testCreatePerson() {
		// Prepare
		Person person = new Person();
		person.setName("Hans");
		person.setAge(42);

		// CUT
		Person createAddressFromPerson = personService.createPerson(person);

		// Asserts
		assertNotNull(createAddressFromPerson);
	}

}
