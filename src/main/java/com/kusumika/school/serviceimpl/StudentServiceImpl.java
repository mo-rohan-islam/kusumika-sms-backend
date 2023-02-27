package com.kusumika.school.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kusumika.school.bean.Student;
import com.kusumika.school.mapper.kusumikadb.StudentMapper;
import com.kusumika.school.service.StudentService;

@Component
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentMapper studentMapper;
	
	@Override
	public Student getStudent(int id) {
		Student student = studentMapper.getStudent(id);
		return student;
	}
	
	@Override
	public List<Student> getStudents() {
		List<Student> studentList = studentMapper.getStudents();
		return studentList;
	}

}
