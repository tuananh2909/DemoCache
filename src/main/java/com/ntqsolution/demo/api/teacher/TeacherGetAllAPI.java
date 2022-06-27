package com.ntqsolution.demo.api.teacher;

import com.ntqsolution.demo.api.BaseAPI;
import com.ntqsolution.demo.entity.AbstractEntity;
import com.ntqsolution.demo.request.BaseRequest;
import com.ntqsolution.demo.response.BaseResponse;
import com.ntqsolution.demo.response.teacher.TeacherGetAllResponse;
import com.ntqsolution.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeacherGetAllAPI extends BaseAPI {
    @Autowired
    TeacherService teacherService;

    @Override
    protected void validateRequest(BaseRequest request) {

    }

    @Override
    protected BaseResponse execute(BaseRequest request) {
        TeacherGetAllResponse response = new TeacherGetAllResponse();
        try {
            List<AbstractEntity> teacherList = teacherService.getTeachers();
            if (teacherList.isEmpty()) {
                return new BaseResponse("Teacher list is empty", HttpStatus.NO_CONTENT);
            }
            response.setTeacherList(teacherList);
            return new BaseResponse("", response, HttpStatus.OK);
        } catch (Exception e) {
            return new BaseResponse("Teacher List is null!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
