package com.navi.rmq.simple;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * SimpleProducer Class
 *
 * @author ganxf
 * @date 2020/7/21
 */
@Slf4j
public class SimpleProducer {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        // 初始化，生产者组名
        DefaultMQProducer producer = new DefaultMQProducer("producerGroup1");
        // 设置namesrv地址
        producer.setNamesrvAddr("namesrvOS:9876");
        producer.start();

        for (int i = 0; i < 100; i++) {
            Message message = new Message("TopicTest", "TagTest", ("hello rocketmq-" + i).getBytes());
            SendResult sendResult = producer.send(message);

            log.info("发送消息返回结果，{}", sendResult);

        }
        producer.shutdown();
    }
}
