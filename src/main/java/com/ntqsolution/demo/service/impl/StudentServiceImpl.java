package com.ntqsolution.demo.service.impl;

import com.ntqsolution.demo.entity.Student;
import com.ntqsolution.demo.redis.impl.StudentRedis;
import com.ntqsolution.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRedis studentRedis;

    @Override
    public void addStudent(Student student) {
        studentRedis.setStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentRedis.setStudent(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentRedis.getStudent();
    }

    @Override
    public Student getStudentById(int id) {
        return studentRedis.getStudentById(id);
    }

    @Override
    public void deleteStudent(int id) {
        studentRedis.deleteStudent(id);
    }
}
