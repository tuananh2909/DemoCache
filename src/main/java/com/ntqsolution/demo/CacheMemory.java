package com.ntqsolution.demo;

import com.ntqsolution.demo.redis.impl.PointRedisRepositoryImpl;
import com.ntqsolution.demo.utils.Const;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CacheMemory {
    public static Map<String, Integer> map = new ConcurrentHashMap<>();

    public static void initCache() {
        map = new PointRedisRepositoryImpl().getPoints(Const.POINT_KEY);
    }

    public static Map<String, Integer> get() {
        if (map == null || map.isEmpty()) {
            return new ConcurrentHashMap<>();
        }
        return map;
    }

    public static void update(Map<String, Integer> points) {
        map = points;
    }

    public static boolean isPointExisted(String point) {
        return map.containsKey(point);
    }
}
