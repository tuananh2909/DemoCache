package com.ntqsolution.demo.api.student;

import com.ntqsolution.demo.api.BaseAPI;
import com.ntqsolution.demo.entity.Student;
import com.ntqsolution.demo.request.BaseRequest;
import com.ntqsolution.demo.response.BaseResponse;
import com.ntqsolution.demo.service.StudentService;
import com.ntqsolution.demo.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class StudentCreateAPI extends BaseAPI {
    @Autowired
    StudentService studentService;

    @Override
    protected void validateRequest(BaseRequest request) {

    }

    @Override
    protected BaseResponse execute(BaseRequest request) {
        Student student = (Student) request.getData();
        try {
            if (Util.isNull(student)) {
                return new BaseResponse("Add failed!!!", HttpStatus.BAD_REQUEST);
            }
            Student newStudent = new Student(student.getName(), student.getPersonClass(), student.getTotalMark());
            studentService.addStudent(newStudent);
            return new BaseResponse("Add student successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new BaseResponse("Add failed!!!", HttpStatus.GATEWAY_TIMEOUT);
        }
    }
}

