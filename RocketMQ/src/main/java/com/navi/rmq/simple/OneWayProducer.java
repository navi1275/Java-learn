package com.navi.rmq.simple;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.concurrent.TimeUnit;

/**
 * OneWayProducer Class
 *
 * @author ganxf
 * @date 2020/7/21
 */
@Slf4j
public class OneWayProducer {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        // 初始化，生产者组名
        DefaultMQProducer producer = new DefaultMQProducer("producerGroup1");
        // 设置namesrv地址
        producer.setNamesrvAddr("namesrvOS:9876");
        producer.start();

        for (int i = 0; i < 100; i++) {
            Message message = new Message("TopicTest2", "TagTest2", ("hello rocketmq-" + i).getBytes());
            producer.sendOneway(message);
        }
        TimeUnit.SECONDS.sleep(5);
        producer.shutdown();
    }
}
