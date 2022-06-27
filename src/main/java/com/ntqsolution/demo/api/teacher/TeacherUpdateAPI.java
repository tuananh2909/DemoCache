package com.ntqsolution.demo.api.teacher;

import com.ntqsolution.demo.api.BaseAPI;
import com.ntqsolution.demo.entity.Teacher;
import com.ntqsolution.demo.request.BaseRequest;
import com.ntqsolution.demo.response.BaseResponse;
import com.ntqsolution.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class TeacherUpdateAPI extends BaseAPI {
    @Autowired
    TeacherService teacherService;

    @Override
    protected void validateRequest(BaseRequest request) {

    }

    @Override
    protected BaseResponse execute(BaseRequest request) {
        Teacher teacher = (Teacher) request.getData();
        try {
            if (teacher == null) {
                return new BaseResponse("Teacher is not found!!!", HttpStatus.NOT_FOUND);
            }
            Teacher oldTeacher = teacherService.getTeacherById((String) request.getData());
            teacher.setId(oldTeacher.getId());
            teacher.setName((teacher.getName() == null) ? oldTeacher.getName() : teacher.getName());
            teacher.setPersonClass((teacher.getPersonClass() == null) ? oldTeacher.getPersonClass() : teacher.getPersonClass());
            teacher.setSubject((teacher.getSubject() == null) ? oldTeacher.getSubject() : teacher.getSubject());
            teacherService.updateTeacher(teacher);
            return new BaseResponse("Update teacher successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new BaseResponse("Update failed!!!", HttpStatus.GATEWAY_TIMEOUT);
        }
    }
}
