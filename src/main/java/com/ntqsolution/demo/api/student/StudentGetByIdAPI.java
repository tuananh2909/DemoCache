package com.ntqsolution.demo.api.student;

import com.ntqsolution.demo.api.BaseAPI;
import com.ntqsolution.demo.entity.Student;
import com.ntqsolution.demo.request.BaseRequest;
import com.ntqsolution.demo.response.BaseResponse;
import com.ntqsolution.demo.response.Response;
import com.ntqsolution.demo.response.student.StudentGetByIdResponse;
import com.ntqsolution.demo.service.StudentService;
import com.ntqsolution.demo.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


@Component
public class StudentGetByIdAPI extends BaseAPI {
    @Autowired
    StudentService studentService;

    @Override
    protected void validateRequest(BaseRequest request) {

    }

    @Override
    protected BaseResponse execute(BaseRequest request) {
        StudentGetByIdResponse response = new StudentGetByIdResponse();
        try {
            Student student = studentService.getStudentById((String) request.getData());
            if (Util.isNull(student)) {
                return new BaseResponse("Student is not found!!!", HttpStatus.NOT_FOUND);
            }
            response.setStudent(student);
            return new BaseResponse("Student is found", response, HttpStatus.OK);
        } catch (Exception e) {
            return new BaseResponse("Student is not found!!!", HttpStatus.GATEWAY_TIMEOUT);
        }
    }
}
