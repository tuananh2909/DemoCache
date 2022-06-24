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
public class StudentUpdateAPI extends BaseAPI {
    @Autowired
    StudentService studentService;

    @Override
    protected void validateRequest(BaseRequest request) {

    }

    @Override
    protected BaseResponse execute(BaseRequest request) {
        Student student = (Student) request.getData();
        try {
            if (student == null) {
                return new BaseResponse("Student is not found!!!", null, HttpStatus.NOT_FOUND);
            }
            Student oldStudent = studentService.getStudentById(student.getId());
            student.setId(oldStudent.getId());
            student.setName((student.getName() == null) ? oldStudent.getName() : student.getName());
            student.setPersonClass((student.getPersonClass() == null) ? oldStudent.getPersonClass() : student.getPersonClass());
            student.setTotalMark(oldStudent.getTotalMark());
            studentService.updateStudent(student);
            return new BaseResponse("Update student successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new BaseResponse("Update failed!!!", null, HttpStatus.GATEWAY_TIMEOUT);
        }
    }
}
