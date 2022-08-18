package com.example.redisdemo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface StudentRepository extends CrudRepository<Student, String> {}