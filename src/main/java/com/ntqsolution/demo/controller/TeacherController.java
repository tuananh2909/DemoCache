package com.ntqsolution.demo.controller;

import com.ntqsolution.demo.entity.Teacher;
import com.ntqsolution.demo.response.ResponseMessage;
import com.ntqsolution.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @GetMapping
    public ResponseEntity<?> getAllTeacher() {
        try {
            List<Teacher> teacherList = teacherService.getTeachers();
            if (teacherList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(teacherList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTeacherById(@PathVariable("id") int id) {
        try {
            Teacher teacher = teacherService.getTeacherById(id);
            if (teacher == null) {
                return new ResponseEntity<>("Teacher is not found!!!!", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(teacher, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Teacher is not found!!!!", HttpStatus.GATEWAY_TIMEOUT);
        }
    }

    @PostMapping
    public ResponseEntity<?> createTeacher(@Validated @RequestBody Teacher teacher) {
        try {
            if (teacher == null) {
                return new ResponseEntity<>("Add failed!!!", HttpStatus.BAD_REQUEST);
            }
            Teacher newTeacher = new Teacher(teacher.getName(), teacher.getPersonClass(), teacher.getSubject());
            teacherService.addTeacher(newTeacher);
            return new ResponseEntity<>("Add teacher successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Add failed!!!", HttpStatus.GATEWAY_TIMEOUT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable("id") int id, @Validated @RequestBody Teacher teacher) {
        try {
            if (teacher == null) {
                return new ResponseEntity<>("Teacher is not found!!!", HttpStatus.NOT_FOUND);
            }
            Teacher oldTeacher = teacherService.getTeacherById(id);
            teacher.setId(oldTeacher.getId());
            teacher.setName((teacher.getName() == null) ? oldTeacher.getName() : teacher.getName());
            teacher.setPersonClass((teacher.getPersonClass() == null) ? oldTeacher.getPersonClass() : teacher.getPersonClass());
            teacher.setSubject((teacher.getSubject() == null) ? oldTeacher.getSubject() : teacher.getSubject());
            teacherService.updateTeacher(teacher);
            return new ResponseEntity<>("Update teacher successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Update failed!!!", HttpStatus.GATEWAY_TIMEOUT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable("id") int id) {
        try {
            Teacher teacher = teacherService.getTeacherById(id);
            if (teacher == null) {
                return new ResponseEntity<>("Teacher is not found!!!", HttpStatus.NOT_FOUND);
            }
            teacherService.deleteTeacher(teacher);
            return new ResponseEntity<>("Delete teacher successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Delete failed!!!", HttpStatus.GATEWAY_TIMEOUT);
        }
    }
}
