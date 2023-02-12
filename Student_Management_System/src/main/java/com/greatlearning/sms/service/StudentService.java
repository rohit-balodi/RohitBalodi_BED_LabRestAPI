package com.greatlearning.sms.service;

import java.util.List;

import com.greatlearning.sms.entity.Student;

public interface StudentService {

	List<Student> getStudentsList();

	Student createNewStudent(Student student);

	void deleteStudent(Integer id) throws Exception;

	Student getStudentById(Integer id) throws Exception;

	Student updateStudent(Integer id, Student student) throws Exception;
	


}
