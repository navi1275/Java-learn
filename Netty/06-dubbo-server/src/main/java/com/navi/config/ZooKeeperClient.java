package com.navi.config;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.CuratorCache;
import org.apache.curator.framework.recipes.cache.CuratorCacheListener;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ZooKeeperClient Class
 *
 * @author ganxf
 * @date 2021/1/25
 */
@Slf4j
public class ZooKeeperClient {


    private static final CuratorFramework curator;

    static{
        curator = CuratorFrameworkFactory.builder()
                .connectString("serverOS:2181")
                .connectionTimeoutMs(5000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .build();
        curator.start();

        try {
            Stat stat = curator.checkExists().forPath("/cdubbo");
            if(stat == null){
                curator.create().forPath("/cdubbo");
            }
        } catch (Exception e) {
            log.error("创建cdubbo根节点出错",  e);
        }


    }

    /**
     * 注册过程就是在providers下创建一个临时节点，一旦提供者关闭连接，删除服务节点
     * @param serviceName
     * @throws Exception
     */
    public static void register(String serviceName) throws Exception {
        String servicePath = "/cdubbo/" + serviceName;
        Stat stat = curator.checkExists().forPath(servicePath);
        if(stat == null){
            curator.create().forPath(servicePath);
        }
        String providersPath = "/cdubbo/" + serviceName  + "/providers";
        Stat stat1 = curator.checkExists().forPath(providersPath);
        if(stat1 == null){
            curator.create().forPath(providersPath);
        }
        // 注册服务为本地地址， 端口为8888
        String hostPath = providersPath + "/127.0.0.1:8888";
        Stat stat2 = curator.checkExists().forPath(hostPath);
        if(stat2 == null){
            curator.create().withMode(CreateMode.EPHEMERAL).forPath(hostPath);
        }

    }
}
