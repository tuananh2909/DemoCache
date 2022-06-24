package com.ntqsolution.demo.controller;

import com.ntqsolution.demo.api.mark.PointMakeAPI;
import com.ntqsolution.demo.api.mark.PointSettingAPI;
import com.ntqsolution.demo.redis.impl.PointRedis;
import com.ntqsolution.demo.request.mark.PointMakeRequest;
import com.ntqsolution.demo.request.mark.PointSettingRequest;
import com.ntqsolution.demo.response.BaseResponse;
import com.ntqsolution.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/marks")
public class MarkController {
    @Autowired
    StudentService studentService;

    @Autowired
    PointRedis pointRedis;

    @Autowired
    PointMakeAPI pointMakeAPI;

    @Autowired
    PointSettingAPI pointSettingAPI;


    @PutMapping("/{id}")
    public BaseResponse makePoint(@PathVariable String id, @RequestBody String point) {
        return pointMakeAPI.doExecute(new PointMakeRequest(id, point));
    }

    @PutMapping
    public BaseResponse settingPoint(@RequestBody Map<String, Integer> points) {
        return pointSettingAPI.doExecute(new PointSettingRequest(points));
    }
}
