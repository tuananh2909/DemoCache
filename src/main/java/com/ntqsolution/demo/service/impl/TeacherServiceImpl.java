package com.ntqsolution.demo.service.impl;

import com.ntqsolution.demo.entity.Teacher;
import com.ntqsolution.demo.redis.impl.TeacherRedis;
import com.ntqsolution.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherRedis teacherRedis;

    @Override
    public void addTeacher(Teacher teacher) {
        teacherRedis.setTeacher(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherRedis.setTeacher(teacher);
    }

    @Override
    public List<Teacher> getTeachers() {
        return teacherRedis.getTeachers();
    }

    @Override
    public Teacher getTeacherById(String id) {
        return teacherRedis.getTeacherById(id);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        teacherRedis.deleteTeacher(teacher.getId());
    }
}
