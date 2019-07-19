package com.navi.netty;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.imps.CuratorFrameworkState;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * ServiceRegistry Class
 *
 * @author navi
 * @date 2019-04-03
 * @since 1.0.0
 */
@Slf4j
@Component
public class ServiceRegistry {

    @Value("${config.zookeeper.address}")
    private String zkAddress;

    private static final String ZK_NODE_PATH = "/smaple";

    private static CuratorFramework client;

    public void register(String data){
        if(data != null && !"".equals(data)){
            CuratorFramework client = connectZookeeper();
            try {
                String path = client.create().forPath("/provider", data.getBytes());
            } catch (Exception e) {
                log.error("创建zknode失败：", data);
            }
        }
    }

    private CuratorFramework connectZookeeper(){
        if(client == null || client.getState() == CuratorFrameworkState.STOPPED) {
            synchronized (ServiceRegistry.class) {
                if(client == null || client.getState() == CuratorFrameworkState.STOPPED) {
                    // 创建重试策略对象：第1秒重试1次，最多重试3次
                    ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(1000, 3);

                    // 创建客户端
                    client = CuratorFrameworkFactory
                            .builder()
                            .connectString(zkAddress)
                            .sessionTimeoutMs(15000)
                            .connectionTimeoutMs(13000)
                            .retryPolicy(retryPolicy)
                            // 指定客户端命名空间，即根节点的子目录
                            .namespace(ZK_NODE_PATH)
                            .build();

                    // 开启客户端
                    client.start();

                    log.info("创建zookeeper客户端，连接zk服务：{}", zkAddress);
                }

            }
        }
        return client;
    }
}
