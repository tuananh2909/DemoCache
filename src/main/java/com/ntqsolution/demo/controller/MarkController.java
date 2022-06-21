package com.ntqsolution.demo.controller;

import com.ntqsolution.demo.CacheMemory;
import com.ntqsolution.demo.entity.Student;
import com.ntqsolution.demo.redis.impl.PointRedis;
import com.ntqsolution.demo.service.StudentService;
import com.ntqsolution.demo.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/marks")
public class MarkController {
    @Autowired
    StudentService studentService;

    @Autowired
    PointRedis pointRedis;


    @GetMapping("/{sid}/{point}")
    public ResponseEntity<?> makePoint(@PathVariable int sid, @PathVariable String point) {
        Map<String, Integer> mapCache = CacheMemory.get();
        Student student = studentService.getStudentById(sid);
        if (student == null || !CacheMemory.isPointExisted(point)) {
            return new ResponseEntity<>("Cannot make point!!!", HttpStatus.NOT_FOUND);
        }
        try {
            student.setTotalMark(student.getTotalMark() + mapCache.get(point));
            studentService.updateStudent(student);
            return new ResponseEntity<>("Make points successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot make point!!!", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping()
    public ResponseEntity<?> settingPoint(@RequestBody Map<String, Integer> points) {
        try {
            for (String key : points.keySet()) {
                pointRedis.setPoints(Const.POINT_KEY, key, String.valueOf(points.get(key)));
            }
            return new ResponseEntity<>("Setting successfully", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Cannot set Point", HttpStatus.BAD_REQUEST);
        }
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
