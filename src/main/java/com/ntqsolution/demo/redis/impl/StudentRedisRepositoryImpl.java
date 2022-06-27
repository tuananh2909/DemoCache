package com.ntqsolution.demo.redis.impl;

import com.ntqsolution.demo.entity.AbstractEntity;
import com.ntqsolution.demo.entity.Student;
import com.ntqsolution.demo.redis.AbstractRepository;
import com.ntqsolution.demo.redis.StudentRedisRepository;
import com.ntqsolution.demo.utils.GsonUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRedisRepositoryImpl extends AbstractRepository<Student> implements StudentRedisRepository {
    private static final String STUDENT_KEY = "Student";


    public void setStudent(Student student) {
        insert(STUDENT_KEY, student.getId(), student);
    }

    public Student getStudentById(String id) {
        return (Student) getEntityById(STUDENT_KEY, id);
    }

    public List<AbstractEntity> getStudent() {
        return getEntities(STUDENT_KEY);
    }

    public void deleteStudent(String id) {
        deleteEntity(STUDENT_KEY, id);
    }


    @Override
    protected Student convertToEntity(String string) {
        return (Student) GsonUtil.convertToObject(string);
    }

    @Override
    protected String convertToDatabaseObject(Student entity) {
        return GsonUtil.convertFromObject(entity);
    }
}
