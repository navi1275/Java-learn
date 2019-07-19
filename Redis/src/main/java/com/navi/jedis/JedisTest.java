package com.navi.jedis;

import com.alibaba.fastjson.JSON;
import com.navi.User;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

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
        // try (JedisPool pool = new JedisPool("192.168.4.129", 6379)) {
        //     Jedis jedis = pool.getResource();
        //     doSomething(jedis);
        //     jedis.close();
        // }

        RedisPool pool = new RedisPool();

        final Holder<String> strHolder = new Holder<>();

        pool.excute(jedis->{
            jedis.connect();

            Set<String> keys = jedis.keys("*");
            for (String key : keys){
                System.out.println("Redis存在Key：" + key);
            }
            User zhangsan = User.builder().name("zhangsan").age(18).id(1).build();

            String key = "user_" + zhangsan.getId();
            String value = JSON.toJSONString(zhangsan);

            strHolder.setValue(jedis.set(key, value));
            System.out.println("jedis.set返回：" + strHolder.getValue());

            String s = jedis.get(key);
            User user = JSON.parseObject(s, User.class);

            System.out.println(user);
        });

        String value = strHolder.getValue();
        System.out.println("这个是妹纸的吧：" + value);
    }

}

class RedisPool {

    private JedisPool pool;

    RedisPool(){
        pool = new JedisPool("192.168.4.129", 6379);
    }

    public void excute(CallWithJedis caller){
        try (Jedis jedis = pool.getResource()) {
            caller.call(jedis);
        }
    }


}

interface CallWithJedis{
    void call(Jedis jedis);
}

class Holder<T> {
    private T value;
    public Holder() {
    }
    public Holder(T value) {
        this.value = value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public T getValue() {
        return value;
    }
}
