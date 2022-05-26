package com.middleware.redis;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import redis.clients.jedis.JedisPubSub;

/**
 * @author: long
 * @create: 2022-05-26 15:02
 * @Description redis发布订阅
 **/
@Slf4j
public class JedisSubscriber extends JedisPubSub {

    @Override
    public void onMessage(String channel, String message) {
        log.info("redis发布订阅");
        if (StringUtils.isNotBlank(message)){

        }
    }
}
