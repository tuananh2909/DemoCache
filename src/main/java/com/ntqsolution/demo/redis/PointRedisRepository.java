package com.ntqsolution.demo.redis;

import java.util.Map;

public interface PointRedisRepository {
    Map<String, Integer> getPoints(String key);

    void setPoints(String key, String field, String value);
}
