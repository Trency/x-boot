package cn.exrick.xboot.config.redis;

import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Created by Administrator on 2017/12/25.
 */
public interface RedisService {

    List<String> get(List<String> keys);

    Map<String, String> getMap(List<String> keys);

    boolean exists(String key) throws Exception;

    String get(String key);

    long del(String key);

    void set(String key, String value);

    void set(String key, String value, int seconds);

    void expire(String key, int seconds);

    void rpush(String key, String... values);

    Map<String, String> blpop(String... keys);

    Long hincr(String key, String field, long increment);

    void hset(String key, String field, String value);

    void hset(String key, String field, String value, int seconds);

    void hmset(String key, Map<String, String> hash);

    void hmset(String key, Map<String, String> hash, int seconds);

    String hget(String key, String field);

    List<String> hmget(String key, String... fields);

    Map<String, String> hgetAll(String key);

    boolean hexists(String key, String field);

    Set<String> hkeys(String key);

    Long hlen(String key);

    Long hdel(String key, String... fields);

    void lpush(String key, String... value);

    List<String> brpop(String key, int timeout);

    Long incrBy(String key, long increment);

    boolean setnx(String key, String value, int seconds);

    JedisPool getJedisPool();

    /**
     * 获取value，如果不存在则重新set
     *
     * @param key      key
     * @param seconds  一级缓存超时时间
     * @param supplier 从其他位置，如db中获取value，并set
     * @return
     */
    String getSetUseLock(String key, int seconds, Supplier<String> supplier);

    /**
     * 获取value，如果不存在则重新set
     *
     * @param key      key
     * @param seconds  一级缓存超时时间
     * @param factor   二级缓存的延时倍数，默认为2.0
     * @param supplier 从其他位置，如db中获取value，并set
     * @return
     */
    String getSetUseLock(String key, int seconds, double factor, Supplier<String> supplier);


    /**
     * redis对象存储
     *
     * @param key
     * @param obj
     * @param seconds
     */
    void setObj(String key, Object obj, int seconds);

    Object getObj(String key);

    Long sadd(String key, String... members);

    Long sadd(String key, int seconds, String... members);

    Set<String> smembers(String key);

}
