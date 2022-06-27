package com.ntqsolution.demo.redis;

import com.ntqsolution.demo.entity.AbstractEntity;
import com.ntqsolution.demo.entity.Student;

import java.util.List;

public interface StudentRedisRepository {
    void setStudent(Student student);

    Student getStudentById(String id);

    List<AbstractEntity> getStudent();

    void deleteStudent(String id);
}
