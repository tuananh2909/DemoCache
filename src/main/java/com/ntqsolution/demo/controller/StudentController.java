package com.ntqsolution.demo.controller;

import com.ntqsolution.demo.api.student.*;
import com.ntqsolution.demo.entity.Student;
import com.ntqsolution.demo.request.student.*;
import com.ntqsolution.demo.response.BaseResponse;
import com.ntqsolution.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    StudentCreateAPI studentCreateAPI;

    @Autowired
    StudentGetByIdAPI studentGetByIdAPI;

    @Autowired
    StudentGetAllAPI studentGetAllAPI;

    @Autowired
    StudentDeleteAPI studentDeleteAPI;

    @Autowired
    StudentUpdateAPI studentUpdateAPI;

    @GetMapping
    public BaseResponse getAllStudent() {
        return studentGetAllAPI.doExecute(new StudentGetAllRequest());
    }

    @GetMapping("/{id}")
    public BaseResponse getStudentById(@PathVariable("id") String id) {
        return studentGetByIdAPI.doExecute(new StudentGetByIdRequest(id));
    }

    @PostMapping
    public BaseResponse createStudent(@Validated @RequestBody Student student) {
        return studentCreateAPI.doExecute(new StudentCreateRequest(student));
    }

    @PutMapping("/{id}")
    public BaseResponse updateStudent(@PathVariable("id") String id, @Validated @RequestBody Student student) {
        student.setId(id);
        return studentUpdateAPI.doExecute(new StudentUpdateRequest(student));
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteStudent(@PathVariable("id") String id) {
        return studentDeleteAPI.doExecute(new StudentDeleteRequest(id));
    }
}
