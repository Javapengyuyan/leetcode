package common.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.*;
import redis.clients.jedis.exceptions.JedisException;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * desc:
 * author:ice
 * date:2018/5/7
 */
@Slf4j
@Component
public class RedisProviderImpl implements RedisProvider {

    @Autowired(required = false)
    private JedisPool jedisPool;


    public void returnResource(Jedis jedis) {
        jedis.close();
    }


    protected Jedis getJedis() throws JedisException {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
        } catch (JedisException e) {

            if (jedis != null) {
                jedis.close();
            }
            throw e;
        }
        return jedis;
    }

    @Override
    public String set(String key, String value) {
        Jedis jedis = getJedis();
        try {
            return jedis.set(key, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }
    @Override
    public String set(String key, String value,Integer index) {
        Jedis jedis = getJedis();
        try {
            jedis.select(index);
            return jedis.set(key, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }

    @Override
    public String get(String key) {
        Jedis jedis = getJedis();
        try {
            return jedis.get(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }
    @Override
    public String get(String key,Integer index) {
        Jedis jedis = getJedis();
        try {
            jedis.select(index);

            return jedis.get(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }

    @Override
    public List batchGet(List<String> keys, Integer index) {
        Jedis jedis = getJedis();
        try {
            jedis.select(index);
            Pipeline pipeline = jedis.pipelined();
            for (String key : keys){
                pipeline.get(key);
            }
            return pipeline.syncAndReturnAll();
        }catch (Exception e){
            log.error("batchGet异常:",e);
        }finally {
            returnResource(jedis);
        }
        return null;
    }

    @Override
    public byte[] getBytes(byte[] key) {
        Jedis jedis = getJedis();
        try {
            return jedis.get(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }

    @Override
    public String setex(byte[] key, Integer second, byte[] value) {
        Jedis jedis = getJedis();
        try {
            return jedis.setex(key, second, value);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }

    @Override
    public String setex(String key, Integer second, String value) {
        Jedis jedis = getJedis();
        try {
            return jedis.setex(key, second, value);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }
    @Override
    public String setex(String key, Integer second, String value,Integer index) {
        Jedis jedis = getJedis();
        try {
            jedis.select(index);
            return jedis.setex(key, second, value);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }

    @Override
    public Long ttl(String accessToken) {
        Jedis jedis = getJedis();
        try {
            return jedis.ttl(accessToken);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }

    @Override
    public Long delete(String key) {
        Jedis jedis = getJedis();
        try {
            return jedis.del(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }
    @Override
    public Long delete(String key,Integer index) {
        Jedis jedis = getJedis();
        try {
            jedis.select(index);
            return jedis.del(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }

    @Override
    public Long delAll(String key,Integer index) {
        Jedis jedis = getJedis();
        jedis.select(index);
        // 游标初始值为0
        String cursor = ScanParams.SCAN_POINTER_START;
        ScanParams scanParams = new ScanParams();
        scanParams.match(key);// 匹配以 key 为前缀的
        scanParams.count(Integer.MAX_VALUE);
        try {
            while (true){
                //使用scan命令获取数据，使用cursor游标记录位置，下次循环使用
                ScanResult<String> scanResult = jedis.scan(cursor, scanParams);
                //todo 报错？？？先注销了
                //cursor = scanResult.getStringCursor();// 返回0 说明遍历完成
                List<String> list = scanResult.getResult();
                //long t1 = System.currentTimeMillis();
                for(int m = 0;m < list.size();m++){
                    String mapentry = list.get(m);
                    //System.out.println(mapentry);
                    jedis.del(key, mapentry);
                }
            /*long t2 = System.currentTimeMillis();
            System.out.println("获取" + list.size()
                    + "条数据，耗时: " + (t2-t1) + "毫秒,cursor:" + cursor);*/
                if ("0".equals(cursor)){
                    break;
                }
            }
        }catch (Exception e){
            log.error("delAll删除报错"+e.getMessage(), e);
        }finally {
            returnResource(jedis);
        }
        return null;
    }

    @Override
    public Long incr(String key) {
        Jedis jedis = getJedis();
        try {
            return jedis.incr(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }

    @Override
    public Long incr(String key,Integer index) {
        Jedis jedis = getJedis();
        try {
            jedis.select(index);
            return jedis.incr(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }

    @Override
    public Long decr(String key,Integer index) {
        Jedis jedis = getJedis();
        try {
            jedis.select(index);
            return jedis.decr(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }

    @Override
    public Set<String> zrangeByScore(String key, double start, double end) {
        Jedis jedis = getJedis();
        try {
            return jedis.zrangeByScore(key, start, end);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }

    @Override
    public Set<String> zrangeByScore(String key, double start, double end,Integer index) {
        Jedis jedis = getJedis();
        jedis.select(index);
        try {
            return jedis.zrangeByScore(key, start, end);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }

    @Override
    public Set<String> zrange(String key, long start, long end) {
        Jedis jedis = getJedis();
        try {
            return jedis.zrange(key, start, end);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }
    @Override
    public Set<String> zrange(String key, long start, long end,Integer index) {
        Jedis jedis = getJedis();
        jedis.select(index);
        try {
            return jedis.zrange(key, start, end);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }

    @Override
    public Set<String> zrevrange(String key, long start, long end) {
        Jedis jedis = getJedis();
        try {
            return jedis.zrevrange(key, start, end);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }

    @Override
    public Long zrevrank(String key, String member) {
        Jedis jedis = getJedis();
        try {
            return jedis.zrevrank(key, member);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }

    @Override
    public Double zscore(String key, String member) {
        Jedis jedis = getJedis();
        try {
            return jedis.zscore(key, member);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }

    @Override
    public Long zcount(String key, double start, double end) {
        Jedis jedis = getJedis();
        try {
            return jedis.zcount(key, start, end);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }

    @Override
    public Long hset(String key, String field, String value) {
        Jedis jedis = getJedis();
        try {
            return jedis.hset(key, field, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }

    @Override
    public Long hset(String key, String field, String value,int index) {
        Jedis jedis = getJedis();
        try {
            jedis.select(index);
            return jedis.hset(key, field, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }


    @Override
    public String hget(String key, String field) {
        Jedis jedis = getJedis();
        try {
            return jedis.hget(key,field);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }

    @Override
    public String hget(String key, String field,int index) {
        Jedis jedis = getJedis();
        try {
            jedis.select(index);
            return jedis.hget(key,field);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }

    @Override
    public Long zadd(String key, double score, String member) {
        Jedis jedis = getJedis();

        try {
            return jedis.zadd(key,score,member);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }
    @Override
    public Long zadd(String key, double score, String member,Integer index) {
        Jedis jedis = getJedis();
        jedis.select(index);
        try {
            return jedis.zadd(key,score,member);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }

    @Override
    public Map<String, String> hgetAll(String key) {
        Jedis jedis = getJedis();
        try {
            return jedis.hgetAll(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }
    @Override
    public String select(Integer index) {
        Jedis jedis = getJedis();
        try {
            return jedis.select(index);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }

    @Override
    public Long hdel(String key, String ...fields) {
        Jedis jedis = getJedis();
        try {
            return jedis.hdel(key, fields);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }
    @Override
    public Long sadd(String key,Integer index,String ...fields) {
        Jedis jedis = getJedis();
        jedis.select(index);
        try {
            return jedis.sadd(key, fields);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }

    /**
     * set获取所有值
     *
     * @param key
     * @param index
     * @return
     */
    @Override
    public Set<String> smembers(String key,Integer index){
        Jedis jedis = getJedis();
        jedis.select(index);
        try {
            return jedis.smembers(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;

    }

    /**
     * set 判断是否含有值
     *
     * @param key
     * @param index
     * @return
     */
    @Override
    public Boolean sismember(String key,Integer index,String element){
        Jedis jedis = getJedis();
        jedis.select(index);
        try {

            return jedis.sismember(key,element);
        } catch (Exception e) {
            log.error("set集合sismember 判断是否含值", e);
        } finally {
            returnResource(jedis);
        }
        return null;

    }

    /**
     * set 判断是否含有值
     *
     * @param key
     * @param index
     * @return
     */
    @Override
    public Boolean exists(String key,Integer index){
        Jedis jedis = getJedis();
        jedis.select(index);
        try {
            return jedis.exists(key);
        } catch (Exception e) {
            log.error("set集合sismember 判断是否含值", e);
        } finally {
            returnResource(jedis);
        }
        return null;

    }



    @Override
    public String flushDB(Integer select) {
        Jedis jedis = getJedis();
        jedis.select(select);
        try {
            return jedis.flushDB();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;

    }

    @Override
    public int dbSize(int select) {
        Jedis jedis = getJedis();
        jedis.select(select);
        try {
            return jedis.dbSize().intValue();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return 0;
    }

    @Override
    public List<String> brpop(int select,int i, String messageKey) {
        Jedis jedis = getJedis();
        jedis.select(select);
        try {
            return jedis.brpop(i,messageKey);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }

    @Override
    public void hmset(int select, String zbUserKey, Map<String, String> userMap, int second) {
        Jedis jedis = getJedis();
        jedis.select(select);
        try {
            jedis.hmset(zbUserKey,userMap);
            jedis.expire(zbUserKey,second);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
    }

    @Override
    public Long expire(String key, int index, int second) {
        Jedis jedis = getJedis();
        jedis.select(index);
        try {
          return   jedis.expire(key,second);
        } catch (Exception e) {
            log.error("设置过期时间异常{}",key, e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }

    @Override
    public void lpush(int select, String messageKey, String msgStr) {
        Jedis jedis = getJedis();
        jedis.select(select);
        try {
            jedis.lpush(messageKey,msgStr);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
    }

    @Override
    /**
     * 获取列表指定位置的值
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<String> lrange(String key, long start, long end,int index) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.select(index);
            return jedis.lrange(key, start, end);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            jedis.close();
        }
        return null;

    }

    @Override
    public void subscribe(int select, JedisPubSub jedisPubSub, String lhzbChannelKey) {
        Jedis jedis = getJedis();
        jedis.select(select);
        try {
            jedis.subscribe(jedisPubSub,lhzbChannelKey);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
    }

    @Override
    public void incrBy(String giveLikeKey, int i, int select) {
        Jedis jedis = getJedis();
        jedis.select(select);
        try {
            jedis.incrBy(giveLikeKey,i);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
    }

    @Override
    public Long scard(String key,Integer select) {
        Jedis jedis = getJedis();
        jedis.select(select);
        try {
            return jedis.scard(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }

    @Override
    public Long srem(String key, Integer select, String... member) {
        Jedis jedis = getJedis();
        jedis.select(select);
        try {
            return jedis.srem(key,member);
        } catch (Exception e) {
            log.error("set集合删除{},{}",key,member, e);
        } finally {
            returnResource(jedis);
        }
        return null;
    }

    @Override
    public Boolean setbit(String key, Long offset, String value) {
        Jedis jedis = getJedis();
        try {
            Boolean setbit = jedis.setbit(key, offset, value);
            return setbit;
        }catch (Exception e){

        }finally {
            returnResource(jedis);
        }
        return null;
    }
}

