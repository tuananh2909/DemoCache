package com.ntqsolution.demo.api.teacher;

import com.ntqsolution.demo.api.BaseAPI;
import com.ntqsolution.demo.entity.Teacher;
import com.ntqsolution.demo.request.BaseRequest;
import com.ntqsolution.demo.response.BaseResponse;
import com.ntqsolution.demo.response.teacher.TeacherGetByIdResponse;
import com.ntqsolution.demo.service.TeacherService;
import com.ntqsolution.demo.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class TeacherGetByIdAPI extends BaseAPI {
    @Autowired
    TeacherService teacherService;

    @Override
    protected void validateRequest(BaseRequest request) {

    }

    @Override
    protected BaseResponse execute(BaseRequest request) {
        TeacherGetByIdResponse response = new TeacherGetByIdResponse();
        try {
            Teacher teacher = teacherService.getTeacherById((String) request.getData());
            if (Util.isNull(teacher)) {
                return new BaseResponse("Teacher is not found!!!!", HttpStatus.NOT_FOUND);
            }
            response.setTeacher(teacher);
            return new BaseResponse("Teacher is found", response, HttpStatus.OK);
        } catch (Exception e) {
            return new BaseResponse("Teacher is not found!!!!", HttpStatus.GATEWAY_TIMEOUT);
        }
    }
}
