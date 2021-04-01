import lombok.extern.slf4j.Slf4j;
import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * ConnectDemo Class
 *
 * @author ganxf
 * @date 2021/1/22
 */
@Slf4j
public class ZkclientDemo {

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        CountDownLatch latch = new CountDownLatch(1);
        ZkClient zkClient = new ZkClient("serverOS:2181");
        zkClient.subscribeDataChanges("/zkdemo/111", new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                log.info("触发节点数据修改事件， {}, {}", s, o);
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                log.info("触发节点数据删除事件， {}, {}", s);

            }
        });

        zkClient.subscribeChildChanges("/zkdemo/111", new IZkChildListener() {

            @Override
            public void handleChildChange(String s, List<String> list) throws Exception {
                log.info("触发子节点修改事件， {}, {}", s, list);

            }
        });

        List<String> list = zkClient.getChildren("/");
        log.info("遍历根节点");
        list.forEach(e -> {
            log.info(e);
        });

        String res = zkClient.create("/zkdemo/111/222", "aaaaaaaaa", CreateMode.PERSISTENT);
        log.info("创建节点/zkdemo/111/222成功:" + res);

        zkClient.writeData("/zkdemo/111/222", "bbbbbbbbb");
        log.info("修改节点/zkdemo/111/222数据成功");

        res = zkClient.readData("/zkdemo/111/222");
        log.info("/zkdemo/111/222节点数据:{}", res);

        Thread.sleep(1000);

        zkClient.delete("/zkdemo/111/222");
        log.info("删除节点/zkdemo/111/222成功");

        Thread.sleep(1000);

        System.out.println("------------------------------------------------");

    }
}
