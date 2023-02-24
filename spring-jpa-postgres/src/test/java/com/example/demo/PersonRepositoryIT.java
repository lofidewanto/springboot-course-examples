package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PersonRepositoryIT {

	@Container
	static PostgreSQLContainer database = new PostgreSQLContainer("postgres:12").withDatabaseName("springboot")
			.withPassword("springboot").withUsername("springboot");

	@DynamicPropertySource
	static void setDatasourceProperties(DynamicPropertyRegistry propertyRegistry) {
		propertyRegistry.add("spring.datasource.url", database::getJdbcUrl);
		propertyRegistry.add("spring.datasource.password", database::getPassword);
		propertyRegistry.add("spring.datasource.username", database::getUsername);

		propertyRegistry.add("spring.flyway.url", database::getJdbcUrl);
		propertyRegistry.add("spring.flyway.password", database::getPassword);
		propertyRegistry.add("spring.flyway.user", database::getUsername);
	}

	@Autowired
	private PersonRepository orderRepository;

	@Test
	void shouldReturnPersons() {
		orderRepository.save(createPerson("Hans", 20));

		List<Person> persons = orderRepository.findAll();

		assertEquals(2, persons.size());
	}

	private Person createPerson(String name, int age) {
		Person person = new Person();
		person.setName("Hans");
		person.setAge(42);
		return person;
	}
}
