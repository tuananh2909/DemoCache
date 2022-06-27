package com.ntqsolution.demo.service.impl;

import com.ntqsolution.demo.entity.AbstractEntity;
import com.ntqsolution.demo.entity.Student;
import com.ntqsolution.demo.redis.impl.StudentRedisRepositoryImpl;
import com.ntqsolution.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRedisRepositoryImpl studentRedisRepositoryImpl;

    @Override
    public void addStudent(Student student) {
        studentRedisRepositoryImpl.setStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentRedisRepositoryImpl.setStudent(student);
    }

    @Override
    public List<AbstractEntity> getStudents() {
        return studentRedisRepositoryImpl.getStudent();
    }

    @Override
    public Student getStudentById(String id) {
        return studentRedisRepositoryImpl.getStudentById(id);
    }

    @Override
    public void deleteStudent(String id) {
        studentRedisRepositoryImpl.deleteStudent(id);
    }
}
