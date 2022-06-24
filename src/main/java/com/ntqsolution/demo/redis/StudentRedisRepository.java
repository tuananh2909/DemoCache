package com.ntqsolution.demo.redis;

import com.ntqsolution.demo.entity.Student;

import java.util.List;

public interface StudentRedisRepository {
    void setStudent(Student student);

    Student getStudentById(String id);

    List<Student> getStudent();

    void deleteStudent(String id);
}
