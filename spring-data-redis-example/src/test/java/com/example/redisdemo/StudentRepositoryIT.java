package com.example.redisdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
public class StudentRepositoryIT {

    static {
        GenericContainer<?> redis = new GenericContainer<>(DockerImageName.parse("redis:5.0.3-alpine"))
                .withExposedPorts(6379)
                .withCommand("redis-server --requirepass mypass");
        redis.start();
        System.setProperty("spring.redis.host", redis.getHost());
        System.setProperty("spring.redis.port", redis.getMappedPort(6379).toString());
    }

    @Autowired
    StudentRepository studentRepository;

    @AfterAll
    public static void setEnvs() {
        // Set the props back to the properties values
        System.setProperty("spring.redis.host", "localhost");
        System.setProperty("spring.redis.port", "6379");
    }
    
    @Test
    public void whenSavingStudent_thenAvailableOnRetrieval() throws Exception {
        Student student = new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
        studentRepository.save(student);
        Student retrievedStudent = studentRepository.findById(student.getId()).get();

        assertEquals(student.getId(), retrievedStudent.getId());
    }

    @Test
    public void whenUpdatingStudent_thenAvailableOnRetrieval() throws Exception {
        Student student = new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
        studentRepository.save(student);
        student.setName("Richard Watson");
        studentRepository.save(student);
        Student retrievedStudent = studentRepository.findById(student.getId()).get();

        assertEquals(student.getName(), retrievedStudent.getName());
    }

    @Test
    public void whenSavingStudents_thenAllShouldAvailableOnRetrieval() throws Exception {
        Student engStudent = new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
        Student medStudent = new Student("Med2015001", "Gareth Houston", Student.Gender.MALE, 2);
        studentRepository.save(engStudent);
        studentRepository.save(medStudent);
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);

        assertEquals(students.size(), 2);
    }

    @Test
    public void whenDeletingStudent_thenNotAvailableOnRetrieval() throws Exception {
        Student student = new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);

        studentRepository.save(student);
        studentRepository.deleteById(student.getId());
        Student retrievedStudent = studentRepository.findById(student.getId()).orElse(null);

        assertNull(retrievedStudent);
    }
}