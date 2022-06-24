package com.ntqsolution.demo.redis.impl;

import com.ntqsolution.demo.entity.Teacher;
import com.ntqsolution.demo.redis.BaseRedis;
import com.ntqsolution.demo.redis.AbstractRepository;
import com.ntqsolution.demo.redis.TeacherRedisRepository;
import com.ntqsolution.demo.utils.GsonUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class TeacherRedis extends AbstractRepository<Teacher> implements TeacherRedisRepository {
    private static final String TEACHER_KEY = "Teacher";

    public void setTeacher(Teacher teacher) {
        insert(TEACHER_KEY, teacher.getId(), teacher);
    }

    public Teacher getTeacherById(String id) {
        return getEntityById(TEACHER_KEY, id);
    }

    public List<Teacher> getTeachers() {
        return getEntities(TEACHER_KEY);
    }

    public void deleteTeacher(String id) {
        deleteEntity(TEACHER_KEY, id);
    }

    @Override
    protected Teacher convertToEntity(String string) {
        return (Teacher) GsonUtil.convertToObject(string);
    }

    @Override
    protected String convertToDatabaseObject(Teacher entity) {
        return GsonUtil.convertFromObject(entity);
    }
}
