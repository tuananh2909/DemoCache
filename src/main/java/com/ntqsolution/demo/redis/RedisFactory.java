package com.ntqsolution.demo.redis;

import com.ntqsolution.demo.utils.Const;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisFactory {

    //private static Jedis jedis = new Jedis();

    private static JedisPool jedisPool = new JedisPool();

    private static final String KEY = "Mark";

    public static Jedis getConnect() {
        //TODO GetTheConnectionFrom ThePool
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            //Specific commands
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            //In JedisPool mode, the Jedis resource is returned to the resource pool.
            if (jedis != null) {
                jedis.close();
            }
        }
        return jedis;
    }

    public static void init() {
        //TODO createJedisPool
        Jedis jedis = getConnect();
        if (!jedis.exists(KEY)) {
            jedis.hset(KEY, "A", String.valueOf(Const.MARK_A));
            jedis.hset(KEY, "B", String.valueOf(Const.MARK_B));
            jedis.hset(KEY, "C", String.valueOf(Const.MARK_C));
        }
    }

    public static void close() {
        jedisPool.close();
    }

}
