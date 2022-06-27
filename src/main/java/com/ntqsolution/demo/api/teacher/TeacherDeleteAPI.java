package com.ntqsolution.demo.api.teacher;

import com.ntqsolution.demo.api.BaseAPI;
import com.ntqsolution.demo.entity.Teacher;
import com.ntqsolution.demo.request.BaseRequest;
import com.ntqsolution.demo.response.BaseResponse;
import com.ntqsolution.demo.service.TeacherService;
import com.ntqsolution.demo.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class TeacherDeleteAPI extends BaseAPI {
    @Autowired
    TeacherService teacherService;

    @Override
    protected void validateRequest(BaseRequest request) {

    }

    @Override
    protected BaseResponse execute(BaseRequest request) {
        try {
            Teacher teacher = teacherService.getTeacherById((String) request.getData());
            if (Util.isNull(teacher)) {
                return new BaseResponse("Teacher is not found!!!", HttpStatus.NOT_FOUND);
            }
            teacherService.deleteTeacher(teacher);
            return new BaseResponse("Delete teacher successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new BaseResponse("Delete failed!!!", HttpStatus.GATEWAY_TIMEOUT);
        }
    }
}
