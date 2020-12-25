package com.patjavahere.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.patjavahere.model.Student;
import com.patjavahere.services.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	private Set<Student> getAllStudent() {
		return this.studentService.getAllStudent();
	}

	@GetMapping("/student/{id}")
	private Student getStudent(@PathVariable("id") final int id) {
		return this.studentService.getStudentById(id);
	}

	@DeleteMapping("/student/{id}")
	private void deleteStudent(@PathVariable("id") final int id) {
		this.studentService.delete(id);
	}

	@PostMapping("/student")
	private int saveStudent(@RequestBody final Student student) {
		this.studentService.saveOrUpdate(student);
		return student.getId();
	}

	@PutMapping("/student")
	private Student update(@RequestBody final Student student) {
		this.studentService.update(student);
		return student;
	}
}