package com.ntqsolution.demo.redis;

import com.ntqsolution.demo.entity.Teacher;

import java.util.List;

public interface TeacherRedisRepository {
    void setTeacher(Teacher teacher);

    List<Teacher> getTeachers();

    Teacher getTeacherById(int id);

    void deleteTeacher(int id);
}
