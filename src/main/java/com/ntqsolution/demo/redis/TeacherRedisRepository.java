package com.ntqsolution.demo.redis;

import com.ntqsolution.demo.entity.Teacher;

import java.util.List;

public interface TeacherRedisRepository {
    void setTeacher(Teacher teacher);

    List<Teacher> getTeachers();

    Teacher getTeacherById(String id);

    void deleteTeacher(String id);
}
