package com.patjavahere.perstistences;

import org.springframework.data.repository.CrudRepository;

import com.patjavahere.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}