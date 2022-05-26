package com.middleware.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

/**
 * @author: long
 * @create: 2022-05-26 16:51
 * @Description
 **/

public class SubThread extends Thread{

    @Resource
    private JedisPool jedisPool;

    private final JedisSubscriber jedisSubscriber = new JedisSubscriber();

    private String channel = "channel";

    @Override
    public void run() {
        Jedis jedis = jedisPool.getResource();
        jedis.subscribe(jedisSubscriber,channel);

    }
}
