package com.ntqsolution.demo.api.student;

import com.ntqsolution.demo.api.BaseAPI;
import com.ntqsolution.demo.entity.Student;
import com.ntqsolution.demo.request.BaseRequest;
import com.ntqsolution.demo.response.BaseResponse;
import com.ntqsolution.demo.response.Response;
import com.ntqsolution.demo.service.StudentService;
import com.ntqsolution.demo.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class StudentDeleteAPI extends BaseAPI {
    @Autowired
    StudentService studentService;

    @Override
    protected void validateRequest(BaseRequest request) {

    }

    @Override
    protected BaseResponse execute(BaseRequest request) {
        try {
            Student student = studentService.getStudentById((String) request.getData());
            if (Util.isNull(student)) {
                return new BaseResponse("Student is not found!!!", null, HttpStatus.NOT_FOUND);
            }
            studentService.deleteStudent((String) request.getData());
            return new BaseResponse("Delete student successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new BaseResponse("Delete failed!!!", HttpStatus.GATEWAY_TIMEOUT);
        }
    }
}
