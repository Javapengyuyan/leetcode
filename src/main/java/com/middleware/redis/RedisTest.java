package com.middleware.redis;

import common.redis.RedisProvider;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author: long
 * @create: 2022-03-20 15:02
 * @Description
 **/

public class RedisTest {

    @Resource
    private RedisProvider redisProvider;

    @Test
    public  void test() {
        Long incr = redisProvider.incr("");
        redisProvider.lpush(3,"lpushKey","1");


    }

}
