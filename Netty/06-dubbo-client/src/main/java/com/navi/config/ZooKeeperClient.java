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

    private static ConcurrentHashMap<String, List<ServiceProviderInfo>> services;

    private static final CuratorFramework curator;

    static{
        curator = CuratorFrameworkFactory.builder()
                .connectString("serverOS:2181")
                .connectionTimeoutMs(5000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .build();
        curator.start();

        //创建监听
        CuratorCache curatorCache = CuratorCache.builder(curator, "/cdubbo").build();
        curatorCache.start();
        curatorCache.listenable().addListener(CuratorCacheListener.builder().forPathChildrenCache("/cdubbo", curator, new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
                // 监听服务提供者注册信息修改，修改本地服务表
                log.info("监听子节点变化，{}", pathChildrenCacheEvent.toString());
            }
        }).build());

        try {
            Stat stat = curator.checkExists().forPath("/cdubbo");
            if(stat == null){
                curator.create().forPath("/cdubbo");
            }
        } catch (Exception e) {
            log.error("创建cdubbo根节点出错",  e);
        }

        try {
            List<String> serviceNameList = curator.getChildren().forPath("/cdubbo");
            if(services != null){
                services.clear();
            }else{
                services = new ConcurrentHashMap<>();
            }
            for (String serviceName : serviceNameList){
                if(StrUtil.isNotBlank(serviceName)) {
                    try {
                        Class<?> aClass = Class.forName(serviceName);
                        String providersPath = "/cdubbo/" + serviceName + "/providers";
                        Stat stat = curator.checkExists().forPath(providersPath);
                        if(stat != null) {
                            List<String> providerList = curator.getChildren().forPath(providersPath);
                            List<ServiceProviderInfo> serviceProviderInfoList = new ArrayList<ServiceProviderInfo>(providerList.size());

                            for (String provider : providerList) {
                                if(StrUtil.isNotBlank(provider)) {
                                    String[] split = StrUtil.split(provider, ":");
                                    if(split.length == 2) {
                                        ServiceProviderInfo serviceProviderInfo = new ServiceProviderInfo();
                                        serviceProviderInfo.setHost(split[0]);
                                        serviceProviderInfo.setPort(Integer.parseInt(split[1]));
                                        serviceProviderInfoList.add(serviceProviderInfo);
                                    }else{
                                        log.warn("{}节点数据不正确", provider);
                                    }
                                }
                            }

                            services.put(serviceName, serviceProviderInfoList);
                        }
                    } catch (ClassNotFoundException e) {
                        log.warn("没有加载到类：{}", serviceName);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ServiceProviderInfo getServiceProviderInfo(String serviceName) {
        List<ServiceProviderInfo> serviceProviderInfos = services.get(serviceName);
        if(CollectionUtil.isNotEmpty(serviceProviderInfos)){
            // 客户端负载均衡
            return serviceProviderInfos.get(0);
        }
        return null;
    }
}
