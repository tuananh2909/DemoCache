package com.ntqsolution.demo.api.mark;

import com.ntqsolution.demo.CacheMemory;
import com.ntqsolution.demo.api.BaseAPI;
import com.ntqsolution.demo.redis.impl.PointRedis;
import com.ntqsolution.demo.request.BaseRequest;
import com.ntqsolution.demo.response.BaseResponse;
import com.ntqsolution.demo.response.mark.MarkSettingResponse;
import com.ntqsolution.demo.response.Response;
import com.ntqsolution.demo.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PointSettingAPI extends BaseAPI {
    @Autowired
    PointRedis pointRedis;

    @Override
    protected void validateRequest(BaseRequest request) {

    }

    @Override
    protected BaseResponse execute(BaseRequest request) {
        Map<String, Integer> points = (Map<String, Integer>) request.getData();
        MarkSettingResponse response = new MarkSettingResponse();
        response.setPoints(points);
        try {
            for (String key : points.keySet()) {
                pointRedis.setPoints(Const.POINT_KEY, key, String.valueOf(points.get(key)));
                CacheMemory.update(points);
            }
            return new BaseResponse("Setting successfully", response, HttpStatus.OK);
        } catch (Exception ex) {
            return new BaseResponse("Cannot set Point", HttpStatus.BAD_REQUEST);
        }
    }
}
