package com.example.demo;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class PersonService {
    
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    
    public Person getPerson(Long id) {
        Optional<Person> person = personRepository.findById(id);

        return person.orElse(null);
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }
    
}
