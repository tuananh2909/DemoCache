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


    @GetMapping("/{sid}/{point}")
    public BaseResponse makePoint(@PathVariable int sid, @PathVariable String point) {
        return pointMakeAPI.doExecute(new PointMakeRequest(point, sid));
//        Map<String, Integer> mapCache = CacheMemory.get();
//        Student student = studentService.getStudentById(sid);
//        if (student == null || !CacheMemory.isPointExisted(point)) {
//            return new ResponseEntity<>("Cannot make point!!!", HttpStatus.NOT_FOUND);
//        }
//        try {
//            student.setTotalMark(student.getTotalMark() + mapCache.get(point));
//            studentService.updateStudent(student);
//            return new ResponseEntity<>("Make points successfully", HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Cannot make point!!!", HttpStatus.BAD_REQUEST);
//        }
    }

    @PutMapping()
    public BaseResponse settingPoint(@RequestBody Map<String, Integer> points) {
        return pointSettingAPI.doExecute(new PointSettingRequest(points));
//        try {
//            for (String key : points.keySet()) {
//                pointRedis.setPoints(Const.POINT_KEY, key, String.valueOf(points.get(key)));
//            }
//            return new ResponseEntity<>("Setting successfully", HttpStatus.OK);
//        } catch (Exception ex) {
//            return new ResponseEntity<>("Cannot set Point", HttpStatus.BAD_REQUEST);
//        }
    }


//    private Map<String, Integer> processMap(Map<String, Integer> map) {
//        if (map == null || map.isEmpty()) {
//            Map<String, String> points = pointRedis.getPoints(Const.POINT_KEY);
//            CacheMemory.add(points);
//            map = CacheMemory.get();
//        }
//        return map;
//    }
}
