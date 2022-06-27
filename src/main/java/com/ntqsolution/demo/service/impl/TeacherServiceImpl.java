package com.ntqsolution.demo.service.impl;

import com.ntqsolution.demo.entity.AbstractEntity;
import com.ntqsolution.demo.entity.Teacher;
import com.ntqsolution.demo.redis.impl.TeacherRedisRepositoryImpl;
import com.ntqsolution.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherRedisRepositoryImpl teacherRedisRepositoryImpl;

    @Override
    public void addTeacher(Teacher teacher) {
        teacherRedisRepositoryImpl.setTeacher(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherRedisRepositoryImpl.setTeacher(teacher);
    }

    @Override
    public List<AbstractEntity> getTeachers() {
        return teacherRedisRepositoryImpl.getTeachers();
    }

    @Override
    public Teacher getTeacherById(String id) {
        return teacherRedisRepositoryImpl.getTeacherById(id);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        teacherRedisRepositoryImpl.deleteTeacher(teacher.getId());
    }
}
