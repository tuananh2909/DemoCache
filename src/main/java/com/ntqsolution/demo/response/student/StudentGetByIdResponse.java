package com.ntqsolution.demo.response.student;

import com.ntqsolution.demo.entity.Student;
import com.ntqsolution.demo.response.Response;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentGetByIdResponse extends Response {

    Student student;
}
