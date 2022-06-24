package com.ntqsolution.demo.api.mark;

import com.ntqsolution.demo.CacheMemory;
import com.ntqsolution.demo.api.BaseAPI;
import com.ntqsolution.demo.entity.Student;
import com.ntqsolution.demo.request.BaseRequest;
import com.ntqsolution.demo.request.mark.PointMakeRequest;
import com.ntqsolution.demo.response.BaseResponse;
import com.ntqsolution.demo.response.Response;
import com.ntqsolution.demo.response.mark.MarkMakeResponse;
import com.ntqsolution.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PointMakeAPI extends BaseAPI {

    @Autowired
    StudentService studentService;

    @Override
    protected void validateRequest(BaseRequest request) {

    }

    @Override
    protected BaseResponse execute(BaseRequest request) {
        PointMakeRequest pointRequest = (PointMakeRequest) request;
        int studentId = pointRequest.getStudentId();
        String point = (String) request.getData();
        int sumMark;
        MarkMakeResponse response = new MarkMakeResponse();
        response.setStudentId(studentId);

        Map<String, Integer> mapCache = CacheMemory.get();
        Student student = studentService.getStudentById(studentId);
        if (student == null || !CacheMemory.isPointExisted(point)) {
            return new BaseResponse("Cannot make point!!!", HttpStatus.NOT_FOUND);
        }
        try {
            student.setTotalMark(student.getTotalMark() + mapCache.get(point));
            studentService.updateStudent(student);
            sumMark = student.getTotalMark();
            response.setTotalPoints(sumMark);
            return new BaseResponse("Make points successfully", response, HttpStatus.OK);
        } catch (Exception e) {
            return new BaseResponse("Cannot make point!!!", HttpStatus.BAD_REQUEST);
        }
    }
}
