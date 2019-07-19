package com.navi.jedis;

import com.alibaba.fastjson.JSON;
import com.navi.User;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisSentinelPool;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * JedisTest Class
 *
 * @author navi
 * @date 2019-04-25
 * @since 1.0.0
 */
public class JedisSentinelTest {

    public static void main(String[] args) throws IOException {

        RedisSentinelPool pool = new RedisSentinelPool();
        pool.excute(jedis->{
            jedis.connect();

            Set<String> keys = jedis.keys("*");
            for (String key : keys){
                System.out.println("Redis存在Key：" + key);
            }
            User zhangsan = User.builder().name("zhangsan").age(18).id(1).build();

            String key = "user_" + zhangsan.getId();
            String value = JSON.toJSONString(zhangsan);

            String ret = jedis.set(key, value);
            System.out.println("jedis.set返回：" + ret);

            String s = jedis.get(key);
            User user = JSON.parseObject(s, User.class);

            System.out.println(user);
        });

        System.in.read();
    }

}

class RedisSentinelPool {

    private JedisSentinelPool pool;

    RedisSentinelPool(){
        HashSet<String> sentinels = new HashSet<>();
        sentinels.add("192.168.4.129:26379");
        sentinels.add("192.168.4.129:26378");
        sentinels.add("192.168.4.129:26377");
        pool = new JedisSentinelPool("mymaster", sentinels);
    }

    public void excute(CallWithJedis caller){
        try (Jedis jedis = pool.getResource()) {
            caller.call(jedis);
        }
    }


}

