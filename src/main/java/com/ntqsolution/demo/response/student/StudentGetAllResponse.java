package com.ntqsolution.demo.response.student;


import com.ntqsolution.demo.entity.Student;
import com.ntqsolution.demo.response.Response;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentGetAllResponse extends Response {

   private List<Student> studentList;
}
