package com.kusumika.school.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kusumika.school.bean.Student;

@Service
public interface StudentService {

	Student getStudent(int id);
	
	Student getStudent(String standard, int rollNo);
	
	List<Student> getStudents();
}
