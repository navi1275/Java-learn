package com.navi.rmq.simple;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * AsyncProducer Class
 *
 * @author ganxf
 * @date 2020/7/21
 */
@Slf4j
public class AsyncProducer {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        // 初始化，生产者组名
        DefaultMQProducer producer = new DefaultMQProducer("producerGroup1");
        // 设置namesrv地址
        producer.setNamesrvAddr("namesrvOS:9876");
        producer.start();
        producer.setRetryTimesWhenSendFailed(0);

        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            final int index = i;
            Message message = new Message("TopicTest1", "TagTest1", "KeysTest1", ("hello, async rocketmq-" + i).getBytes());
            producer.send(message, new SendCallback(){

                @Override
                public void onSuccess(SendResult sendResult) {
                    countDownLatch.countDown();
                    log.info("发送成功，index:{}, sendResult: {}", index,  sendResult);
                }

                @Override
                public void onException(Throwable throwable) {
                    countDownLatch.countDown();
                    log.error("发送异常，index:{},异常信息:{}", index, throwable);
                }
            });

        }
        // 等待发送消息回调完成再关闭
        countDownLatch.await(5, TimeUnit.SECONDS);
        log.info("消息回调完成，关闭服务");
        producer.shutdown();
    }
}
