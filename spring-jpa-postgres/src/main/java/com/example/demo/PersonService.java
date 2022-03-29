package com.example.demo;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {
    
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    
    @Transactional(readOnly = true)
    public Person getPerson(Long id) {
        Optional<Person> person = personRepository.findById(id);

        return person.orElse(null);
    }

    @Transactional
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }
    
}
