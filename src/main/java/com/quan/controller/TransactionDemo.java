package com.quan.controller;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * @author: long
 * @create: 2022-11-28 17:38
 * @Description
 **/

public class TransactionDemo {

    public static void main(String[] args) {
        Jedis jedis = new Jedis();
        String userId = "abc";
        String key = keyFor(userId);
        jedis.setnx(key,String.valueOf(5));
        System.out.println(doubleAccount(jedis,userId));

    }

    private static int doubleAccount(Jedis jedis, String userId) {
        String key = keyFor(userId);
        while (true){
            jedis.watch(key);
            int value = Integer.parseInt(jedis.get(key));
            value *= 2;
            Transaction tx = jedis.multi();
            tx.set(key,String.valueOf(value));
            List<Object> res = tx.exec();
            if (res != null){
                break;
            }
        }
        return Integer.parseInt(jedis.get(key));
    }

    private static String keyFor(String userId) {
        return String.format("account_{}",userId);
    }

}
