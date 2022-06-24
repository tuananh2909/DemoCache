package com.ntqsolution.demo.service;

import com.ntqsolution.demo.entity.Teacher;

import java.util.List;

public interface TeacherService {
    void addTeacher(Teacher teacher);

    void updateTeacher(Teacher teacher);

    List<Teacher> getTeachers();

    Teacher getTeacherById(String id);

    void deleteTeacher(Teacher teacher);
}
