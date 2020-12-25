package com.patjavahere.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patjavahere.model.Student;
import com.patjavahere.perstistences.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public Set<Student> getAllStudent() {
		final var students = new HashSet<Student>();
		this.studentRepository.findAll().forEach(student -> students.add(student));
		return students;
	}

	public Student getStudentById(final int id) {
		return this.studentRepository.findById(id).get();
	}

	public void saveOrUpdate(final Student student) {
		this.studentRepository.save(student);
	}

	public void delete(final int id) {
		this.studentRepository.deleteById(id);
	}

	public void update(final Student student) {
		this.studentRepository.save(student);
	}
}