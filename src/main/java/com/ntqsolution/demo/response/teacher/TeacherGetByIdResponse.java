package com.ntqsolution.demo.response.teacher;

import com.ntqsolution.demo.entity.Student;
import com.ntqsolution.demo.entity.Teacher;
import com.ntqsolution.demo.response.Response;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherGetByIdResponse extends Response {

    Teacher teacher;
}
