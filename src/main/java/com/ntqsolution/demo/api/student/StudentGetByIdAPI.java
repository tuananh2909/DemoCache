package com.ntqsolution.demo.api.student;

import com.ntqsolution.demo.api.BaseAPI;
import com.ntqsolution.demo.entity.Student;
import com.ntqsolution.demo.request.BaseRequest;
import com.ntqsolution.demo.response.BaseResponse;
import com.ntqsolution.demo.response.Response;
import com.ntqsolution.demo.service.StudentService;
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
        try {
            Student student = studentService.getStudentById((Integer) request.getData());
            if (student == null) {
                return new BaseResponse("Student is not found!!!", HttpStatus.NOT_FOUND);
            }
            return new BaseResponse("Student is found", null, HttpStatus.OK);
        } catch (Exception e) {
            return new BaseResponse("Student is not found!!!", HttpStatus.GATEWAY_TIMEOUT);
        }
    }
}
