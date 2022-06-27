package com.ntqsolution.demo;

import com.ntqsolution.demo.redis.impl.PointRedisRepositoryImpl;
import com.ntqsolution.demo.redis.RedisFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    PointRedisRepositoryImpl pointRedisRepositoryImpl;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        RedisFactory.init();
        CacheMemory.initCache();
//        CacheMemory.add(pointRedis.getPoints(Const.POINT_KEY));
    }
}
