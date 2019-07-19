package com.navi.jedis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;
import java.util.HashSet;

/**
 * JedisClusterTest Class
 *
 * @author navi
 * @date 2019-07-08
 * @since 1.0.0
 */
public class JedisClusterTest {

    public static void main(String[] args) {
        HashSet<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.4.129", 7000));
        nodes.add(new HostAndPort("192.168.4.129", 7001));
        nodes.add(new HostAndPort("192.168.4.129", 7002));
        nodes.add(new HostAndPort("192.168.4.129", 7003));
        nodes.add(new HostAndPort("192.168.4.129", 7004));
        nodes.add(new HostAndPort("192.168.4.129", 7005));
        nodes.add(new HostAndPort("192.168.4.129", 7006));
        nodes.add(new HostAndPort("192.168.4.129", 7007));

        try (JedisCluster jedisCluster = new JedisCluster(nodes)) {
            jedisCluster.set("jedis-cluster-test", "aaaaaa");
            String s = jedisCluster.get("jedis-cluster-test");
            System.out.println(s);
        }catch (IOException ex){

        }
    }
}
