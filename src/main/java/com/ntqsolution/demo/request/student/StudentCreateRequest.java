package com.ntqsolution.demo.request.student;

import com.ntqsolution.demo.entity.Student;
import com.ntqsolution.demo.request.BaseRequest;
import lombok.*;

@Getter
@Setter
public class StudentCreateRequest extends BaseRequest<Student> {
    public StudentCreateRequest(Student data) {
        super(data);
    }
}
