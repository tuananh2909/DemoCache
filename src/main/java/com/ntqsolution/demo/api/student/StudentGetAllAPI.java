package com.ntqsolution.demo.api.student;

import com.ntqsolution.demo.api.BaseAPI;
import com.ntqsolution.demo.entity.Student;
import com.ntqsolution.demo.request.BaseRequest;
import com.ntqsolution.demo.response.BaseResponse;
import com.ntqsolution.demo.response.ResponseMessage;
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
        try {
            List<Student> studentList = studentService.getStudents();
            if (studentList.isEmpty()) {
                return new ResponseMessage("List student is empty!!!", HttpStatus.NO_CONTENT);
            }
            return new ResponseMessage("", studentList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseMessage("Cannot have list student", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
