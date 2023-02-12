package com.greatlearning.sms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.sms.entity.Student;
import com.greatlearning.sms.repository.StudentRepository;

@Service
public class StudentServiceImplimentation implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getStudentsList() {
        return studentRepository.findAll();
    }

    @Override
    public Student createNewStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Integer id, Student student) throws Exception {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(!optionalStudent.isPresent())
            throw new Exception("OOPS!! student not present");
        Student oldStudent = optionalStudent.get();
        if(student.getFirstName() != null)
            oldStudent.setFirstName(student.getFirstName());
        if(student.getLastName() != null)
            oldStudent.setLastName(student.getLastName());
        if(student.getCourse() != null)
            oldStudent.setCourse(student.getCourse());
        if(student.getCountry() != null)
            oldStudent.setCountry(student.getCountry());

        Student updatedStudent = oldStudent;

        studentRepository.save(updatedStudent);

        return updatedStudent;
    }

    @Override
    public void deleteStudent(Integer id) throws Exception {
        Optional<Student> optinalStudent = studentRepository.findById(id);

        if(!optinalStudent.isPresent())
            throw new Exception("OOPS!! student not present");

        Student studentToDelete = optinalStudent.get();
        studentRepository.delete(studentToDelete);
    }

    @Override
    public Student getStudentById(Integer id) throws Exception {

        Optional<Student> optinalStudent = studentRepository.findById(id);

        if(!optinalStudent.isPresent())
            throw new Exception("OOPS!! student not present");

        return optinalStudent.get();
    }
}
