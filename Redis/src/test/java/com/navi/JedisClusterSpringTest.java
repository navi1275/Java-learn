package com.navi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * ImportTestData Class
 *
 * @author navi
 * @date 2019-06-18
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class JedisClusterSpringTest {

    @Autowired
    private JedisCluster jedisCluster;


    @Test
    public void test() throws IOException {

        String s = jedisCluster.get("jedis-cluster-test");
        System.out.println(s);
    }

}
