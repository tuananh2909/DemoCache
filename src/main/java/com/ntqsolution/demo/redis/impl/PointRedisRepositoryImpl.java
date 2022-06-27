package com.ntqsolution.demo.redis.impl;

import com.ntqsolution.demo.redis.BaseRedis;
import com.ntqsolution.demo.redis.PointRedisRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class PointRedisRepositoryImpl extends BaseRedis implements PointRedisRepository {
    public Map<String, Integer> getPoints(String key) {
        //TODO convert Map<String,String> to Map<String, Integer>
        Map<String, Integer> map = new ConcurrentHashMap<>();
        for (String keys : getAll(key).keySet()) {
            map.put(keys, Integer.parseInt(getAll(key).get(keys)));
        }
        return map;
    }

    public void setPoints(String key, String field, String value) {
        set(key, field, value);
    }
}
