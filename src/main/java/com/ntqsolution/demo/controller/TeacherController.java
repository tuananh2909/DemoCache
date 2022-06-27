package com.ntqsolution.demo.controller;

import com.ntqsolution.demo.api.teacher.*;
import com.ntqsolution.demo.entity.Teacher;
import com.ntqsolution.demo.request.student.StudentDeleteRequest;
import com.ntqsolution.demo.request.teacher.TeacherCreateRequest;
import com.ntqsolution.demo.request.teacher.TeacherGetAllRequest;
import com.ntqsolution.demo.request.teacher.TeacherGetByIdRequest;
import com.ntqsolution.demo.request.teacher.TeacherUpdateRequest;
import com.ntqsolution.demo.response.BaseResponse;
import com.ntqsolution.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @Autowired
    TeacherGetAllAPI teacherGetAllAPI;

    @Autowired
    TeacherGetByIdAPI teacherGetByIdAPI;

    @Autowired
    TeacherCreateAPI teacherCreateAPI;

    @Autowired
    TeacherUpdateAPI teacherUpdateAPI;

    @Autowired
    TeacherDeleteAPI teacherDeleteAPI;

    @GetMapping
    public BaseResponse getAllTeacher() {
        return teacherGetAllAPI.doExecute(new TeacherGetAllRequest());
    }

    @GetMapping("/{id}")
    public BaseResponse getTeacherById(@PathVariable("id") String id) {
        return teacherGetByIdAPI.doExecute(new TeacherGetByIdRequest(id));
    }

    @PostMapping
    public BaseResponse createTeacher(@Validated @RequestBody Teacher teacher) {
        return teacherCreateAPI.doExecute(new TeacherCreateRequest(teacher));
    }

    @PutMapping("/{id}")
    public BaseResponse updateTeacher(@PathVariable("id") String id, @Validated @RequestBody Teacher teacher) {
        teacher.setId(id);
        return teacherUpdateAPI.doExecute(new TeacherUpdateRequest(teacher));
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteTeacher(@PathVariable("id") String id) {
        return teacherDeleteAPI.doExecute(new StudentDeleteRequest(id));
    }
}
