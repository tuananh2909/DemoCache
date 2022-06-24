package com.ntqsolution.demo.request.student;

import com.ntqsolution.demo.entity.Student;
import com.ntqsolution.demo.request.BaseRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentGetAllRequest extends BaseRequest {
    List<Student> studentList;
}
