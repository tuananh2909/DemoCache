package com.ntqsolution.demo.redis.impl;

import com.google.gson.Gson;
import com.ntqsolution.demo.entity.Student;
import com.ntqsolution.demo.redis.BaseRedis;
import com.ntqsolution.demo.redis.StudentRedisRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRedis extends BaseRedis implements StudentRedisRepository {
    private static final String STUDENT_KEY = "Student";

    private final Gson gson = new Gson();

    public void setStudent(Student student) {
        set(STUDENT_KEY, Integer.toString(student.getId()), gson.toJson(student));
    }

    public Student getStudentById(int id) {
        String student = get(STUDENT_KEY, Integer.toString(id));
        return gson.fromJson(student, Student.class);
    }

    public List<Student> getStudent() {
        Map<String, String> students = getAll(STUDENT_KEY);
        List<Student> studentList = new ArrayList<>();
        for (String keys : students.keySet()) {
            studentList.add(gson.fromJson(students.get(keys), Student.class));
        }
        return studentList;
    }

    public void deleteStudent(int id) {
        delete(STUDENT_KEY, Integer.toString(id));
    }
}
