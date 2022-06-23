package com.ntqsolution.demo.request.student;

import com.ntqsolution.demo.entity.Student;
import com.ntqsolution.demo.request.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentUpdateRequest extends BaseRequest<Student> {
    public StudentUpdateRequest(Student data) {
        super(data);
    }
}
