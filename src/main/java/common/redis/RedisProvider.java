package common.redis;

import redis.clients.jedis.JedisPubSub;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * desc:
 * author:ice
 * date:2018/5/7
 */
public interface RedisProvider {

    /**
     * 设置指定 key 的值
     *
     * @param key
     * @param value
     * @return
     */
      String set(String key, String value) ;
    /**
     * 设置指定 key 的值
     *
     * @param key
     * @param value
     * @return
     */
    String set(String key, String value, Integer index) ;

    /**
     * 获取指定key的值
     * @param key
     * @return
     */
      String get(String key);
      String get(String key, Integer index);

      List batchGet(List<String> keys, Integer index);

    /**
     * 获取指定key的值
     * @param key
     * @return
     */
    byte[] getBytes(byte[] key);

    /**
     * 设置key的值 并且设置过期时间
     * @param key
     * @param second 过期时间
     * @param value
     * @return
     */
     String setex(byte[] key, Integer second, byte[] value);
    /**
     * 设置key的值 并且设置过期时间
     * @param key
     * @param second 过期时间
     * @param value
     * @return
     */
    String setex(String key, Integer second, String value, Integer index);
    /**
     * 设置key的值 并且设置过期时间
     * @param key
     * @param second 过期时间
     * @param value
     * @return
     */
    String setex(String key, Integer second, String value);
    /**
     * 根据key来查找key的剩余有效时间
     * @param key
     * @return
     */
    Long ttl(String key);

    Long delete(String key);
    Long delete(String key, Integer index);

    Long delAll(String key, Integer index);

    Long incr(String guestUseridIncrKey);
    Long incr(String guestUseridIncrKey, Integer index);
    Long decr(String guestUseridDecrKey, Integer index);

    /**
     * 通过分数返回有序集合指定区间内的成员
     * @param key
     * @param start
     * @param end
     * @return
     */
    Set<String> zrangeByScore(String key, double start, double end);

    /**
     *  返回有序集中，指定区间内的成员
     * @param key
     * @param start
     * @param end
     * @return
     */
    Set<String> zrange(String key, long start, long end);
    /**
     *  返回有序集中，指定区间内的成员
     * @param key
     * @param start
     * @param end
     * @return
     */
    Set<String> zrange(String key, long start, long end, Integer index);


    /**
     *  指定库 返回有序集中，指定区间内的成员
     * @param key
     * @param start
     * @param end
     * @return
     */
    Set<String> zrangeByScore(String key, double start, double end, Integer index);

    /**
     * 返回有序集中指定区间内的成员，通过索引，分数从高到底
     * @param key
     * @param start
     * @param end
     * @return
     */
    Set<String> zrevrange(String key, long start, long end);

    /**
     * 返回有序集中，成员的分数值
     * @param key
     * @param member
     * @return
     */
    Double zscore(String key, String member);

    /**
     * 返回有序集中成员的排名。其中有序集成员按分数值递减(从大到小)排序
     * @param key
     * @param member
     * @return
     */
    Long zrevrank(String key, String member);

    /**
     * 命令用于计算有序集合中指定分数区间的成员数量
     * @param key
     * @param start
     * @param end
     * @return
     */
    Long zcount(String key, double start, double end);

    /**
     * 将哈希表 key 中的字段 field 的值设为 value
     *
     * @param key
     * @param field
     * @param value
     * @return
     */
    Long hset(String key, String field, String value);

    Long hset(String key, String field, String value, int index);

    /**
     * 返回哈希表中指定字段的值
     * @param key
     * @param field
     * @return
     */
    String hget(String key, String field);

    String hget(String key, String field, int index);

    /**
     * 增加有序集合元素
     * @param key
     * @param score
     * @param member
     * @return
     */
    Long zadd(String key, double score, String member);
    /**
     * 指定数据库，增加有序集合元素
     * @param key
     * @param score
     * @param member
     * @return
     */
    Long zadd(String key, double score, String member, Integer index);

    /**
     *切换数据库
     * @param index
     * @return
     */
     String select(Integer index) ;

     /*
     * 返回给定所有集合的差集并存储在 dstkey 中
     *
     * @param
     * @param key
     * @return
     */
     Map<String, String> hgetAll(String key);

    /**
     * 删除一个哈希表字段
     *
     * @param key
     * @param fields
     * @return
     */
     Long hdel(String key, String... fields);
    /**
     * set添加值
     *
     * @param key
     * @param index
     * @param fields
     * @return
     */
    Long sadd(String key, Integer index, String... fields);

    /**
     * set获取所有值
     *
     * @param key
     * @param index
     * @return
     */
    Set<String> smembers(String key, Integer index);

    /**
     *  判断是否存在该值
     * @param key
     * @param index
     * @param element
     * @return
     */
    Boolean sismember(String key, Integer index, String element);

    /**
     *  判断是否存在key
     * @param key
     * @param index
     * @return
     */
    Boolean exists(String key, Integer index);



    /**
     * 刷新数据库
     * @param select 选择数据库
     */
    String flushDB(Integer select);

    /**
     * 查询数据库大小
     * @param select 选择数据库
     * @return
     */
    int dbSize(int select);

    /***
     * 获取列表
     * @param i
     * @param messageKey
     * @return
     */
    List<String> brpop(int select, int i, String messageKey);

    /***
     * map存储
     * @param select
     * @param zbUserKey
     * @param userMap
     * @param second
     */
    void hmset(int select, String zbUserKey, Map<String, String> userMap, int second);

    /***
     *
     * @param key
     * @param index
     * @param second
     * @return
     */
    Long expire(String key, int index, int second);

    /***
     * 存入数据
     * @param select
     * @param messageKey
     * @param msgStr
     */
    void lpush(int select, String messageKey, String msgStr);

    /**
     * 获取列表指定位置的值
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
     List<String> lrange(String key, long start, long end, int index);

    /***
     * 订阅
     * @param select
     * @param jedisPubSub
     * @param lhzbChannelKey
     */
    void subscribe(int select, JedisPubSub jedisPubSub, String lhzbChannelKey);

    /***
     * 自增
     * @param giveLikeKey
     * @param i
     * @param select
     */
    void incrBy(String giveLikeKey, int i, int select);

    /**
     * set获取集合中元素的数量
     *
     * @param key
     * @param index
     * @return
     */
    Long scard(String key, Integer index);

    /***
     * 删除该元素
     * @param key
     * @param index
     * @param memeber
     * @return
     */
    Long srem(String key, Integer index, String... memeber);

    /**
     * bitmap
     * @param key key
     * @param offset 偏移量
     * @param value value
     * @return
     */
    Boolean setbit(String key,Long offset,String value);


}
