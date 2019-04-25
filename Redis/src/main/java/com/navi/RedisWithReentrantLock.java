package com.navi;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * RedisWithReentrantLock Class
 * Redis的可重入锁实现
 *
 * @author navi
 * @date 2019-04-25
 * @since 1.0.0
 */
public class RedisWithReentrantLock {

    /**
     * 线程变量
     */
    private ThreadLocal<Map> lockers = new ThreadLocal<>();

    /**
     * jedis客户端
     */
    private Jedis jedis;

    public RedisWithReentrantLock(Jedis jedis) {
        this.jedis = jedis;
    }

    /**
     * 上锁
     * @param key
     * @return
     */
    public boolean lock(String key) {
        Map<String, Integer> lockers = currentLockers();
        Integer count = lockers.get(key);
        if (count != null) {
            lockers.put(key, count + 1);
            return true;
        }

        boolean ok = this._lock(key);
        if (!ok) {
            return false;
        }
        lockers.put(key, 1);
        return true;
    }

    /**
     * 解锁
     * @param key
     * @return
     */
    public boolean unlock(String key) {
        Map<String, Integer> lockers = currentLockers();
        Integer count = lockers.get(key);
        if (count == null) {
            return false;
        }

        count--;
        if (count > 0) {
            lockers.put(key, count);
        } else {
            lockers.remove(key);
            this._unlock(key);
        }
        return true;
    }


    private Map<String, Integer> currentLockers() {
        Map map = lockers.get();
        if (map != null) {
            return map;
        }
        lockers.set(new HashMap());

        return lockers.get();
    }


    private boolean _lock(String key) {
        return jedis.set(key, "1", "NX", "EX", 5) != null;
    }

    private void _unlock(String key) {
        jedis.del(key);
    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.4.129", 6379);
        RedisWithReentrantLock lock = new RedisWithReentrantLock(jedis);
        System.out.println(lock.lock("lock#aaa"));
        System.out.println(lock.lock("lock#aaa"));
        System.out.println(lock.unlock("lock#aaa"));
        System.out.println(lock.unlock("lock#aaa"));

    }
}
