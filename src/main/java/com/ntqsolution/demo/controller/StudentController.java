package com.ntqsolution.demo.controller;

import com.ntqsolution.demo.entity.Student;
import com.ntqsolution.demo.response.ResponseMessage;
import com.ntqsolution.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<?> getAllStudent() {
        try {
            List<Student> studentList = studentService.getStudents();
            if (studentList.isEmpty()) {
                return new ResponseEntity<>(new ResponseMessage("List student is empty!!!", null), HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(studentList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") int id) {
        try {
            Student student = studentService.getStudentById(id);
            if (student == null) {
                return new ResponseEntity<>(new ResponseMessage("Student is not found", null), HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage("Student is not found", null), HttpStatus.GATEWAY_TIMEOUT);
        }
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@Validated @RequestBody Student student) {
        try {
            if (student == null) {
                return new ResponseEntity<>(new ResponseMessage("Add failed!!!", null), HttpStatus.BAD_REQUEST);
            }
            Student newStudent = new Student(student.getName(), student.getPersonClass(), student.getTotalMark());
            studentService.addStudent(newStudent);
            return new ResponseEntity<>("Add student successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage("Add failed!!!", null), HttpStatus.GATEWAY_TIMEOUT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable("id") int id, @Validated @RequestBody Student student) {
        try {
            if (student == null) {
                return new ResponseEntity<>(new ResponseMessage("Student is not found!!!", null), HttpStatus.NOT_FOUND);
            }
            Student oldStudent = studentService.getStudentById(id);
            student.setId(oldStudent.getId());
            student.setName((student.getName() == null) ? oldStudent.getName() : student.getName());
            student.setPersonClass((student.getPersonClass() == null) ? oldStudent.getPersonClass() : student.getPersonClass());
            student.setTotalMark(oldStudent.getTotalMark());
            studentService.updateStudent(student);
            return new ResponseEntity<>("Update student successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage("Update failed!!!", null), HttpStatus.GATEWAY_TIMEOUT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") int id) {
        try {
            Student student = studentService.getStudentById(id);
            if (student == null) {
                return new ResponseEntity<>(new ResponseMessage("Student is not found!!!", null), HttpStatus.NOT_FOUND);
            }
            studentService.deleteStudent(id);
            return new ResponseEntity<>("Delete student successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage("Delete failed!!!", null), HttpStatus.GATEWAY_TIMEOUT);
        }

    }
}
