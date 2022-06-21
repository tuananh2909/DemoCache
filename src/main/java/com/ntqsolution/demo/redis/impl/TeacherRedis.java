package com.ntqsolution.demo.redis.impl;

import com.google.gson.Gson;
import com.ntqsolution.demo.entity.Teacher;
import com.ntqsolution.demo.redis.BaseRedis;
import com.ntqsolution.demo.redis.TeacherRedisRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class TeacherRedis extends BaseRedis implements TeacherRedisRepository {
    private static final String TEACHER_KEY = "Teacher";
    private final Gson gson = new Gson();

    public void setTeacher(Teacher teacher) {
        set(TEACHER_KEY, Integer.toString(teacher.getId()), gson.toJson(teacher));
    }

    public Teacher getTeacherById(int id) {
        String teacher = get(TEACHER_KEY, Integer.toString(id));
        return gson.fromJson(teacher, Teacher.class);
    }

    public List<Teacher> getTeachers() {
        Map<String, String> teachers = getAll(TEACHER_KEY);
        List<Teacher> listTeachers = new ArrayList<>();
        for (String keys : teachers.keySet()) {
            listTeachers.add(gson.fromJson(teachers.get(keys), Teacher.class));
        }
        return listTeachers;
    }

    public void deleteTeacher(int id) {
        delete(TEACHER_KEY, Integer.toString(id));
    }
}
