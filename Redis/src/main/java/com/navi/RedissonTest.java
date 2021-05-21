package com.navi;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * RedissonTest Class
 *
 * @author navi
 * @date 2019-06-28
 * @since 1.0.0
 */
public class RedissonTest {

    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://redisOs:6379");
        RedissonClient client = Redisson.create(config);

        RLock lock = client.getLock("redissonLock");
        // lock.lock();
        lock.lock(3, TimeUnit.SECONDS);
        boolean locked = lock.isLocked();
        System.out.println(locked);
        lock.unlock();


        RMap<String, User> redissonMap = client.getMap("redissonMap");
        User user1 = new User();
        user1.setId(1);
        User obj = redissonMap.put("user123", user1);
        User user323 = redissonMap.putIfAbsent("user323", user1);
        User user2 = new User();
        user2.setId(2);
        User user123 = redissonMap.putIfAbsent("user123", user2);

        User user3 = new User();
        user3.setId(3);
        User user1231 = redissonMap.putIfAbsent("user123", user3);
        System.out.println(redissonMap);
        redissonMap.remove("user123");
        System.out.println(redissonMap);


    }
}
