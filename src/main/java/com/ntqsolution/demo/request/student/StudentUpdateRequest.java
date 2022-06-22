package com.ntqsolution.demo.request.student;

import com.ntqsolution.demo.entity.Student;
import com.ntqsolution.demo.request.BaseRequest;
import com.ntqsolution.demo.response.BaseResponse;

public class StudentUpdateRequest extends BaseRequest<Student> {
    public StudentUpdateRequest(Student data) {
        super(data);
    }
}
