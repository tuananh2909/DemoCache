package com.ntqsolution.demo.api.student;

import com.ntqsolution.demo.api.BaseAPI;
import com.ntqsolution.demo.entity.AbstractEntity;
import com.ntqsolution.demo.request.BaseRequest;
import com.ntqsolution.demo.response.BaseResponse;
import com.ntqsolution.demo.response.student.StudentGetAllResponse;
import com.ntqsolution.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentGetAllAPI extends BaseAPI {
    @Autowired
    StudentService studentService;

    @Override
    protected void validateRequest(BaseRequest request) {

    }

    @Override
    protected BaseResponse execute(BaseRequest request) {
        StudentGetAllResponse response = new StudentGetAllResponse();
        try {
            List<AbstractEntity> studentList = studentService.getStudents();
            if (studentList.isEmpty()) {
                return new BaseResponse("List student is empty!!!", HttpStatus.NO_CONTENT);
            }
            response.setStudentList(studentList);
            return new BaseResponse("Student list is have", response, HttpStatus.OK);
        } catch (Exception e) {
            return new BaseResponse("Cannot have list student", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
