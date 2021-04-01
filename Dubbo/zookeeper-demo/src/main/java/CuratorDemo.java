import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * ConnectDemo Class
 *
 * @author ganxf
 * @date 2021/1/22
 */
@Slf4j
public class CuratorDemo {

    public static void main(String[] args) throws Exception {
        try (CuratorFramework curator = CuratorFrameworkFactory.builder()
                .connectString("serverOS:2181")
                .connectionTimeoutMs(5000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .build()) {
            curator.start();//连接

            //创建监听
            CuratorCache curatorCache = CuratorCache.builder(curator, "/zkdemo").build();
            curatorCache.start();
            curatorCache.listenable().addListener(CuratorCacheListener.builder().forPathChildrenCache("/zkdemo", curator, new PathChildrenCacheListener() {
                @Override
                public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
                    log.info("监听子节点变化，{}", pathChildrenCacheEvent.toString());
                }
            }).build());

            Stat stat = curator.checkExists().forPath("/zkdemo/111");
            if (stat != null) {
                log.info("【/zkdemo/111】节点存在，直接删除");
                curator.delete().forPath("/zkdemo/111");
            }
            System.in.read();

            log.info("准备创建【/zkdemo/111】");
            curator.create().withMode(CreateMode.PERSISTENT)
                    .forPath("/zkdemo/111", "love forever".getBytes());
            log.info("节点【/zkdemo/111】创建成功");

            Thread.sleep(1000);

            byte[] bs = curator.getData().forPath("/zkdemo/111");
            log.info("节点【/zkdemo/111】数据:{}", new String(bs));

            Thread.sleep(1000);

            curator.delete().forPath("/zkdemo/111");
        }

        Thread.sleep(1000);

    }
}
