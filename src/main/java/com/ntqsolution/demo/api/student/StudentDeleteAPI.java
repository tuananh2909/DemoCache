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

@Component
public class StudentDeleteAPI extends BaseAPI {
    @Autowired
    StudentService studentService;

    @Override
    protected void validateRequest(BaseRequest request) {

    }

    @Override
    protected BaseResponse execute(Object data) {
        try {
            Student student = studentService.getStudentById((Integer) data);
            if (student == null) {
                return new ResponseMessage("Student is not found!!!", null, HttpStatus.NOT_FOUND);
            }
            studentService.deleteStudent((Integer) data);
            return new ResponseMessage("Delete student successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseMessage("Delete failed!!!", null, HttpStatus.GATEWAY_TIMEOUT);
        }
    }
}
