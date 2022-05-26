package com.middleware.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

/**
 * @author: long
 * @create: 2022-05-26 16:58
 * @Description redis的publish
 **/

public class Publisher {

    @Resource
    private JedisPool jedisPool;

    private String key = "channel";

    public void start(){
        Jedis jedis = jedisPool.getResource();
        jedis.publish(key,"value");

    }

}
