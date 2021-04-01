import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * ConnectDemo Class
 *
 * @author ganxf
 * @date 2021/1/22
 */
@Slf4j
public class ConnectDemo {

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        CountDownLatch latch = new CountDownLatch(1);

        Watcher watcher = new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                log.info("zookeeper注册事件处理器");

                if(Event.KeeperState.SyncConnected == event.getState()){
                    Event.EventType type = event.getType();
                    switch (type) {
                        case None:

                            latch.countDown();
                            break;
                        case NodeCreated:
                            log.info("创建节点,{}", event);
                            break;
                        case NodeDeleted:
                            log.info("删除节点,{}", event);
                            break;
                        case NodeDataChanged:
                            log.info("修改节点数据,{}", event);
                            break;
                        case NodeChildrenChanged:
                            log.info("修改子节点数据,{}", event);
                            break;
                        case DataWatchRemoved:
                            break;
                        case ChildWatchRemoved:
                            break;
                        case PersistentWatchRemoved:
                            break;
                    }
                }

            }
        };

        ZooKeeper zooKeeper = new ZooKeeper("serverOS:2181", 5000, watcher);
        latch.await();
        log.info("zookeeper 连接成功, {}", zooKeeper.getState());

        zooKeeper.exists("/zkdemo/111", watcher);

        // 创建永久节点
        String s = zooKeeper.create("/zkdemo/111", "zhangsan".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        log.info("创建节点,{}", s);


        // 创建临时节点
        String s1 = zooKeeper.create("/zkdemo/222", "lisi".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        log.info("创建临时节点, {}", s1);


        zooKeeper.exists("/zkdemo/111", watcher);

        // zooKeeper.
        // 修改节点
        Stat stat = zooKeeper.setData("/zkdemo/111", "wangwu".getBytes(), -1);
        log.info("修改节点, {}", stat);


        zooKeeper.exists("/zkdemo/111", watcher);

        byte[] data = zooKeeper.getData("/zkdemo/111", false, null);
        log.info("节点数据:{}", new String(data));

        List<String> children = zooKeeper.getChildren("/zkdemo", null);
        for (String ss : children){
            log.info("子节点，{}", ss);
        }


        zooKeeper.exists("/zkdemo/111", watcher);

        zooKeeper.delete("/zkdemo/111", -1);
    }
}
