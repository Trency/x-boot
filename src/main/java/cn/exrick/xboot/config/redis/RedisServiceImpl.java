package cn.exrick.xboot.config.redis;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.*;
import java.util.*;
import java.util.function.Supplier;

/**
 * Created by Administrator on 2017/12/25.
 */
@Service
public class RedisServiceImpl implements RedisService {

    protected final Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);

    private static final String LOCK_KEY = "lock";

    private static final String LOCK_VALUE = "1";

    private static final int LOCK_EXPIRE = 10;

    private static final String L2_KEY = "l2";

    private static final double DEFAULT_L2_EXPIRE_FACTOR = 2.0;

//  @Autowired
//  private JedisPool jedisPool;

    @Autowired
    private JedisPool jedisPool;

    @Override
    public List<String> get(List<String> keys) {
        logger.debug("START get, keys={}", keys);
        List<String> result = null;
        if (!CollectionUtils.isEmpty(keys)) {
            Jedis jedis = null;
            try {
                jedis = jedisPool.getResource();
                result = jedis.mget(keys.toArray(new String[0]));
            } catch (Exception e) {
                logger.error("Caught Redis Exception: {}", e.getMessage(), e);
            } finally {
                close(jedis);
            }

        }
        logger.debug("END get, result={}", result);
        if (result == null) {
            result = Collections.emptyList();
        }
        return result;
    }

    @Override
    public Map<String, String> getMap(List<String> keys) {
        logger.debug("START getMap, keys: {}", keys);
        List<String> list = get(keys);
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = list.get(i);
            map.put(key, value);
        }
        logger.debug("END mgetMap, result: {}", map);
        return map;
    }

    @Override
    public Long hincr(String key, String field, long increment) {
        logger.debug("start redis hincr: key={}, field={}, increment={}", key, field, increment);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Long value = jedis.hincrBy(key, field, increment);
            logger.info("redis hset: key={}, field={}, value={}", key, field, value);
            return value;
        } catch (Exception e) {
            logger.error("Caught Redis Exception: {}", e.getMessage(), e);
        } finally {
            close(jedis);
        }
        return null;
    }

    @Override
    public void hset(String key, String field, String value) {
        logger.debug("start: hset redis cache. key={}, field={}, value={}", key, field, value);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.hset(key, field, value);
        } catch (Exception e) {
            logger.error("Redis exception: {}", e.getMessage(), e);
        } finally {
            close(jedis);
        }
    }

    @Override
    public void hset(String key, String field, String value, int seconds) {
        logger.debug("start: hset redis cache. key={}, field={}, value={}, expire={}", key, field, value, seconds);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.hset(key, field, value);
            jedis.expire(key, seconds);
        } catch (Exception e) {
            logger.error("Redis exception: {}", e.getMessage(), e);
        } finally {
            close(jedis);
        }
    }

    @Override
    public void hmset(String key, Map<String, String> hash) {
        logger.debug("start: hmset redis cache. key={}, hash={}", key, hash);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.hmset(key, hash);
        } catch (Exception e) {
            logger.error("Redis exception: {}", e.getMessage(), e);
        } finally {
            close(jedis);
        }
    }

    @Override
    public void hmset(String key, Map<String, String> hash, int seconds) {
        logger.debug("start: hmset redis cache. key={}, hash={}, expire={}", key, hash, seconds);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.hmset(key, hash);
            jedis.expire(key, seconds);
        } catch (Exception e) {
            logger.error("Redis exception: {}", e.getMessage(), e);
        } finally {
            close(jedis);
        }
    }

    @Override
    public String hget(String key, String field) {
        logger.debug("start: hget redis cache. key={}, field={}", key, field);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String value = jedis.hget(key, field);
            logger.debug("end: key={}, field={}, value={}", key, field, value);
            return value;
        } catch (Exception e) {
            logger.error("Caught Redis Exception: {}", e.getMessage(), e);
        } finally {
            close(jedis);
        }
        return null;
    }

    @Override
    public List<String> hmget(String key, String... fields) {
        logger.debug("start: hmget redis cache. key={}, fields={}", key, fields);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            List<String> value = jedis.hmget(key, fields);
            logger.debug("end: key={}, fields={}, value={}", key, fields, value);
            return value;
        } catch (Exception e) {
            logger.error("Caught Redis Exception: {}", e.getMessage(), e);
        } finally {
            close(jedis);
        }
        return null;
    }

    @Override
    public Long incrBy(String key, long increment) {
        logger.debug("start redis hincr: key={}, field={}, increment={}", key, increment);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Long value = jedis.incrBy(key, increment);
            logger.info("redis hset: key={}, field={}, value={}", key, value);
            return value;
        } catch (Exception e) {
            logger.error("Caught Redis Exception: {}", e.getMessage(), e);
        } finally {
            close(jedis);
        }
        return null;
    }

    @Override
    public Map<String, String> hgetAll(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Map<String, String> map = jedis.hgetAll(key);
            return map;
        } catch (Exception e) {
            logger.error("Caught Redis Exception: {}", e.getMessage(), e);
        } finally {
            close(jedis);
        }
        return null;
    }

    @Override
    public boolean hexists(String key, String field) {
        logger.debug("start: hexists in redis cache. key={}, field={}", key, field);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Boolean isExisted = jedis.hexists(key, field);
            logger.debug("end: key={}, field={}, exists={}", key, field, isExisted);
            return isExisted;
        } catch (Exception e) {
            logger.error("Caught Redis Exception: {}", e.getMessage(), e);
        } finally {
            close(jedis);
        }
        return false;
    }

    @Override
    public Set<String> hkeys(String key) {
        logger.debug("start: hkeys in redis cache. key={}", key);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Set<String> hkeys = jedis.hkeys(key);
            logger.debug("end: key={}, hkeys={}", key, hkeys);
            return hkeys;
        } catch (Exception e) {
            logger.error("Caught Redis Exception: {}", e.getMessage(), e);
        } finally {
            close(jedis);
        }
        return null;
    }

    @Override
    public Long hlen(String key) {
        logger.debug("start: hlen in redis cache. key={}", key);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Long hlen = jedis.hlen(key);
            logger.debug("end: key={}, hlen={}", key, hlen);
            return hlen;
        } catch (Exception e) {
            logger.error("Caught Redis Exception: {}", e.getMessage(), e);
        } finally {
            close(jedis);
        }
        return null;
    }

    @Override
    public Long hdel(String key, String... fields) {
        logger.debug("start: hdel redis cache. key={}, fields={}", key, fields);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Long hdel = jedis.hdel(key, fields);
            logger.debug("end: key={}, hdel={}", key, hdel);
            return hdel;
        } catch (Exception e) {
            logger.error("Caught Redis Exception: {}", e.getMessage(), e);
        } finally {
            close(jedis);
        }
        return null;
    }

    @Override
    public boolean exists(String key) throws Exception {
        logger.debug("start: exists in redis cache. key={}", key);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Boolean isExisted = jedis.exists(key);
            logger.debug("end: key={}, exists={}", key, isExisted);
            return isExisted;
        } catch (Exception e) {
            logger.error("Caught Redis Exception: {}", e.getMessage(), e);
            throw new Exception(e.getMessage());
        } finally {
            close(jedis);
        }
    }

    @Override
    public String get(String key) {
        logger.debug("start: get redis cache. key={}", key);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String value = jedis.get(key);
            logger.debug("end: key={}, value={}", key, value);
            return value;
        } catch (Exception e) {
            logger.error("Caught Redis Exception: {}", e.getMessage(), e);
        } finally {
            close(jedis);
        }
        return null;
    }

    @Override
    public long del(String key) {
        logger.debug("start: del redis cache. key={}", key);

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Long del = jedis.del(key);
            logger.debug("end: key={}, return={}", key, del);

            if (del != null) {
                return del;
            }
        } catch (Exception e) {
            logger.error("Caught Redis Exception: {}", e.getMessage(), e);
        } finally {
            close(jedis);
        }
        return 0;
    }

    @Override
    public void set(String key, String value) {
        logger.debug("start: set redis cache. key={}, value={}", key, value);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
        } catch (Exception e) {
            logger.error("Redis exception: {}", e.getMessage(), e);
        } finally {
            close(jedis);
        }
    }

    @Override
    public void set(String key, String value, int seconds) {
        logger.debug("start: set redis cache. key={}, value={}, expire={}", key, value, seconds);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
            jedis.expire(key, seconds);
        } catch (Exception e) {
            logger.error("Redis exception: {}", e.getMessage(), e);
        } finally {
            close(jedis);
        }
    }

    @Override
    public void setObj(String key, Object obj, int seconds) {

        logger.debug("start: set redis obj cache. key={}, value={}, expire={}", key, obj, seconds);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key.getBytes(), serialize(obj));
            jedis.expire(key, seconds);
        } catch (Exception e) {
            logger.error("Redis exception: {}", e.getMessage(), e);
        } finally {
            close(jedis);
        }

    }

    @Override
    public Object getObj(String key) {
        logger.debug("start: get redis obj cache. key={}", key);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Object object = null;
            //获取value的类型
            String type = jedis.type(key);
            //根据不同类型调用不同的获取方法
            if (type.toLowerCase().equals("map")) {
                object = jedis.hgetAll(key);
            } else if (type.toLowerCase().equals("set")) {
                object = jedis.smembers(key);
            } else if (type.toLowerCase().equals("list")) {
                object = jedis.lrange(key, 0, -1);
            } else if (type.toLowerCase().equals("string")) {
                byte[] bytes = jedis.get(key.getBytes());
                object = unserialize(bytes);
                if (object == null) {
                    object = jedis.get(key);
                }
            }
            logger.debug("end: key={}, value={}", key, object);
            return object;
        } catch (Exception e) {
            logger.error("Caught Redis Exception: {}", e.getMessage(), e);
        } finally {
            close(jedis);
        }
        return null;

    }

    @Override
    public Long sadd(String key, String... members) {
        logger.debug("start: set redis cache. key={}, members={}, expire={}", key, members);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Long sadd = jedis.sadd(key, members);
            logger.debug("end: key={}, sadd={}", key, sadd);
            return sadd;
        } catch (Exception e) {
            logger.error("Redis exception: {}", e.getMessage(), e);
        } finally {
            close(jedis);
        }
        return -1L;
    }

    @Override
    public Long sadd(String key, int seconds, String... members) {
        logger.debug("start: set redis cache. key={}, members={}, expire={}", key, members, seconds);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Long sadd = jedis.sadd(key, members);
            jedis.expire(key, seconds);
            logger.debug("end: key={}, sadd={}, expire={}", key, sadd, seconds);
            return sadd;
        } catch (Exception e) {
            logger.error("Redis exception: {}", e.getMessage(), e);
        } finally {
            close(jedis);
        }
        return -1L;
    }

    @Override
    public Set<String> smembers(String key) {
        logger.debug("start: smembers in redis cache. key={}", key);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Set<String> smembers = jedis.smembers(key);
            logger.debug("end: key={}, smembers={}", key, smembers);
            return smembers;
        } catch (Exception e) {
            logger.error("Caught Redis Exception: {}", e.getMessage(), e);
        } finally {
            close(jedis);
        }
        return null;
    }

    @Override
    public boolean setnx(String key, String value, int seconds) {
        logger.debug("start: set redis cache. key={}, value={}, expire={}", key, value, seconds);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (jedis.setnx(key, value) == 1) {
                jedis.expire(key, seconds);
                return true;
            }

        } catch (Exception e) {
            logger.error("Redis exception: {}", e.getMessage(), e);
        } finally {
            close(jedis);
        }
        return false;
    }

    @Override
    public void expire(String key, int seconds) {
        logger.debug("start: expire key={}, expire={}", key, seconds);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.expire(key, seconds);
        } catch (Exception e) {
            logger.error("Redis exception: {}", e.getMessage(), e);
        } finally {
            close(jedis);
        }
    }

    @Override
    public Map<String, String> blpop(String... keys) {
        logger.debug("start: blpop redis. keys={}", (Object[]) keys);
        Jedis jedis = null;
        Map<String, String> map = new HashMap<String, String>();
        do {
            try {
                jedis = jedisPool.getResource();
                List<String> list = jedis.brpop(300, keys);
                if (CollectionUtils.isEmpty(list)) {
                    continue;
                }
                for (int i = 1; i < list.size(); i += 2) {
                    String key = list.get(i - 1);
                    String value = list.get(i);
                    map.put(key, value);
                }
            } catch (Exception e) {
                logger.error("Redis exception: {}", e.getMessage(), e);
            } finally {
                close(jedis);
            }
        } while (map.isEmpty());
        return map;
    }

    @Override
    public void rpush(String key, String... values) {
        logger.debug("start: rpush redis. key={}, values={}", key, values);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.rpush(key, values);
        } catch (Exception e) {
            logger.error("Redis exception: {}", e.getMessage(), e);
        } finally {
            close(jedis);
        }
    }

    /**
     * 存储REDIS队列 顺序存储
     *
     * @param key   reids键名
     * @param value 键值
     */
    @Override
    public void lpush(String key, String... value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.lpush(key, value);
        } catch (Exception e) {
            close(jedis);
            e.printStackTrace();
        } finally {
            close(jedis);
        }
    }

    @Override
    public List<String> brpop(String key, int timeout) {
        List<String> list = null;
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            list = jedis.brpop(timeout, key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(jedis);
        }
        return list;
    }

    private void close(Jedis jedis) {
        if (jedis != null) {
            try {
                jedis.close();
            } catch (Exception e) {

            }
        }
    }

    @Override
    public JedisPool getJedisPool() {
        return jedisPool;
    }

    @Override
    public String getSetUseLock(String key, int seconds, Supplier<String> supplier) {
        return getSetUseLock(key, seconds, DEFAULT_L2_EXPIRE_FACTOR, supplier);
    }

    @Override
    public String getSetUseLock(String key, int seconds, double factor, Supplier<String> supplier) {
        logger.debug("start: getSetUseLock redis. key={}", key);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String value = jedis.get(key);
            if (value != null) {
                logger.debug("end: key={}, value={}", key, value);
                return value;
            }
            String lockKey = key + ":" + LOCK_KEY;
            String l2Key = key + ":" + L2_KEY;
            // 暂时不用requestId
            boolean acquired = RedisLockTool.tryGetDistributedLock(jedis, lockKey, LOCK_VALUE, seconds);
            // 获取不到锁，返回二级缓存
            if (!acquired) {
                String l2Value = jedis.get(l2Key);
                logger.debug("end: value is getting by another thread, return l2 cache, key={}, value = {}", l2Key, l2Value);
                return l2Value;
            }
            // 获取到锁，查询数据
            String supplierValue = supplier.get();
            logger.debug("get value from supplier, value={}", supplierValue);
            jedis.set(key, supplierValue);
            jedis.expire(key, seconds);
            logger.debug("redis set: key={}, value={}, expire={}", key, supplierValue, seconds);
            jedis.set(l2Key, supplierValue);
            int l2Expire = (int) (seconds * factor);
            jedis.expire(l2Key, l2Expire);
            logger.debug("redis set: key={}, value={}, expire={}", l2Key, supplierValue, l2Expire);
            boolean released = RedisLockTool.releaseDistributedLock(jedis, lockKey, LOCK_VALUE);
            if (!released) {
                logger.warn("redis releaseDistributedLock fail");
            }
            return supplierValue;
        } catch (Exception e) {
            logger.error("Caught Redis Exception: {}", e.getMessage(), e);
        } finally {
            close(jedis);
        }
        return null;
    }


    //序列化
    private byte[] serialize(Object obj) {
        ObjectOutputStream obi = null;
        ByteArrayOutputStream bai = null;
        try {
            bai = new ByteArrayOutputStream();
            obi = new ObjectOutputStream(bai);
            obi.writeObject(obj);
            byte[] byt = bai.toByteArray();
            return byt;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //反序列化
    private Object unserialize(byte[] byt) {
        ObjectInputStream oii = null;
        ByteArrayInputStream bis = null;
        bis = new ByteArrayInputStream(byt);
        try {
            oii = new ObjectInputStream(bis);
            Object obj = oii.readObject();
            return obj;
        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }

}
