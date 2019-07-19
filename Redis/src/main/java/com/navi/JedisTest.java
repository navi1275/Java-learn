package com.navi;

import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * JedisTest Class
 *
 * @author navi
 * @date 2019-04-25
 * @since 1.0.0
 */
public class JedisTest {

    public static void main(String[] args) {
        try (Jedis jedis = new Jedis("192.168.4.129", 6379)) {
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

        }

    }
}
