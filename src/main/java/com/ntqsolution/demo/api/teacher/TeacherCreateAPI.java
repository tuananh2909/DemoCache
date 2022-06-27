package com.ntqsolution.demo.api.teacher;

import com.ntqsolution.demo.api.BaseAPI;
import com.ntqsolution.demo.entity.Teacher;
import com.ntqsolution.demo.request.BaseRequest;
import com.ntqsolution.demo.response.BaseResponse;
import com.ntqsolution.demo.service.TeacherService;
import com.ntqsolution.demo.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class TeacherCreateAPI extends BaseAPI {
    @Autowired
    TeacherService teacherService;

    @Override
    protected void validateRequest(BaseRequest request) {

    }

    @Override
    protected BaseResponse execute(BaseRequest request) {
        Teacher teacher = (Teacher) request.getData();
        try {
            if (Util.isNull(teacher)) {
                return new BaseResponse("Add failed!!!", HttpStatus.BAD_REQUEST);
            }
            Teacher newTeacher = new Teacher(teacher.getName(), teacher.getPersonClass(), teacher.getSubject());
            teacherService.addTeacher(newTeacher);
            return new BaseResponse("Add teacher successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new BaseResponse("Add failed!!!", HttpStatus.GATEWAY_TIMEOUT);
        }
    }
}
