package com.kusumika.school.mapper.kusumikadb;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kusumika.school.bean.Student;

@Mapper
public interface StudentMapper {

	Student getStudent(@Param("id") int id);
	
	Student getStudentWithClassRoll(@Param("standard") String standard, @Param("rollNo") int rollNo);
	
	List<Student> getStudents();
	
}
