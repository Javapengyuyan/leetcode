package com.middleware.Redisson;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author: long
 * @create: 2022-07-27 09:12
 * @Description
 **/
@Configuration
public class RedissonConfig {

    @Autowired
    private RedissonClient redissonClient;


    public void config(){
        Config config = new Config();
        config.useClusterServers()
                .setScanInterval(2000)
                .addNodeAddress("redis://127.16.1.54")
                .addNodeAddress("");
        RedissonClient redissonClient = Redisson.create(config);
    }

    public Object getLock(String lockName){
        RedissonClient redisson = Redisson.create();
        RLock lock = redisson.getLock(lockName);
        lock.lock();
        lock.lock(5, TimeUnit.SECONDS);
        try {
            boolean tryLock = lock.tryLock(5, 20, TimeUnit.SECONDS);
            if (tryLock){

            }
            return tryLock;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return false;
    }

}
