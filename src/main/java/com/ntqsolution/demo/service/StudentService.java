package com.ntqsolution.demo.service;

import com.ntqsolution.demo.entity.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);

    void updateStudent(Student student);

    List<Student> getStudents();

    Student getStudentById(String id);

    void deleteStudent(String id);
}
