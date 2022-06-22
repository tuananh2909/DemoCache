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
//        try {
//            List<Student> studentList = studentService.getStudents();
//            if (studentList.isEmpty()) {
//                return new ResponseEntity<>(new ResponseMessage("List student is empty!!!", null), HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(studentList, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    }

    @GetMapping("/{id}")
    public BaseResponse getStudentById(@PathVariable("id") int id) {
        return studentGetByIdAPI.doExecute(new StudentGetByIdRequest(id));
//        try {
//            Student student = studentService.getStudentById(id);
//            if (student == null) {
//                return new ResponseEntity<>("Student is not found", HttpStatus.NOT_FOUND);
//            }
//            return new ResponseEntity<>(student, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Student is not found", HttpStatus.GATEWAY_TIMEOUT);
//        }
    }

    @PostMapping
    public BaseResponse createStudent(@Validated @RequestBody Student student) {
        return studentCreateAPI.doExecute(new StudentCreateRequest(student));
//        try {
//            if (student == null) {
//                return new ResponseEntity<>(new ResponseMessage("Add failed!!!", null), HttpStatus.BAD_REQUEST);
//            }
//            Student newStudent = new Student(student.getName(), student.getPersonClass(), student.getTotalMark());
//            studentService.addStudent(newStudent);
//            return new ResponseEntity<>("Add student successfully", HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ResponseMessage("Add failed!!!", null), HttpStatus.GATEWAY_TIMEOUT);
//        }
    }

    @PutMapping("/{id}")
    public BaseResponse updateStudent(@PathVariable("id") int id, @Validated @RequestBody Student student) {
//        try {
//            if (student == null) {
//                return new ResponseEntity<>(new ResponseMessage("Student is not found!!!", null), HttpStatus.NOT_FOUND);
//            }
//            Student oldStudent = studentService.getStudentById(id);
//            student.setId(oldStudent.getId());
//            student.setName((student.getName() == null) ? oldStudent.getName() : student.getName());
//            student.setPersonClass((student.getPersonClass() == null) ? oldStudent.getPersonClass() : student.getPersonClass());
//            student.setTotalMark(oldStudent.getTotalMark());
//            studentService.updateStudent(student);
//            return new ResponseEntity<>("Update student successfully", HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ResponseMessage("Update failed!!!", null), HttpStatus.GATEWAY_TIMEOUT);
//        }
        return studentUpdateAPI.doExecute(new StudentUpdateRequest(student));
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteStudent(@PathVariable("id") int id) {
//        try {
//            Student student = studentService.getStudentById(id);
//            if (student == null) {
//                return new ResponseEntity<>(new ResponseMessage("Student is not found!!!", null), HttpStatus.NOT_FOUND);
//            }
//            studentService.deleteStudent(id);
//            return new ResponseEntity<>("Delete student successfully", HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ResponseMessage("Delete failed!!!", null), HttpStatus.GATEWAY_TIMEOUT);
//        }
        return studentDeleteAPI.doExecute(new StudentDeleteRequest(id));
    }
}
