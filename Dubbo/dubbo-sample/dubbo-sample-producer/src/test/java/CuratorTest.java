import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.BoundedExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * CuratorTest Class
 *
 * @author navi
 * @date 2019-04-03
 * @since 1.0.0
 */

@RunWith(JUnit4.class)
public class CuratorTest {

    private static final String zkOs = "192.168.4.129:2181";

    @Test
    public void test() throws Exception {
        BoundedExponentialBackoffRetry retryPolicy = new BoundedExponentialBackoffRetry(1000, 5000, 3);
        CuratorFramework client = CuratorFrameworkFactory.builder().connectString(zkOs).sessionTimeoutMs(18000).connectionTimeoutMs(18000).namespace("logs").retryPolicy(retryPolicy).build();

        client.start();

        // String path = client.create().forPath("/hello", "hello".getBytes());
        byte[] bytes = client.getData().forPath("/hello");
        System.out.println(new String(bytes));

        Stat stat = client.checkExists().forPath("/hello");
        System.out.println(stat.toString());

        client.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath("/hello2");
        client.create().withMode(CreateMode.EPHEMERAL).forPath("/hello2");

        Thread.sleep(5000);


    }
}
