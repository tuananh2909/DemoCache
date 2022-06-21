package com.ntqsolution.demo.redis;

import redis.clients.jedis.Jedis;

import java.util.Map;

public abstract class BaseRedis {
    protected Jedis getConnection() {
        return RedisFactory.getConnect();
    }

    protected void set(String key, String filed, String value) {
        try {
            Jedis jedis = getConnection();
            jedis.hset(key, filed, value);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    protected Map<String, String> getAll(String key) {
        try {
            Jedis jedis = getConnection();
            return jedis.hgetAll(key);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

    protected String get(String key, String field) {
        try {
            Jedis jedis = getConnection();
            return jedis.hget(key, field);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

    protected void delete(String key, String filed) {
        try {
            Jedis jedis = getConnection();
            jedis.hdel(key, filed);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
