package com.kusumika.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kusumika.school.bean.Student;
import com.kusumika.school.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/student")
@Slf4j
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/{id}")
	public Student getStudent(@PathVariable int id) {
		log.info("Fetching student with id {}", id);
		return studentService.getStudent(id);
	}
	
	@GetMapping()
	public List<Student> getStudents() {
		log.info("Fetching all student details");
		return studentService.getStudents();
	}

}
