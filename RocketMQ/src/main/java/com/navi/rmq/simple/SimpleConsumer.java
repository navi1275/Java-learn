package com.navi.rmq.simple;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.List;

/**
 * SimpleProducer Class
 *
 * @author ganxf
 * @date 2020/7/21
 */
@Slf4j
public class SimpleConsumer {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        // 初始化，消费者组名
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumerGroup1");
        // 设置namesrv地址
        consumer.setNamesrvAddr("namesrvOS:9876");
        // 注册一个topic，接收tag，使用null或者"*"接收全部，可以使用 "tag1 || tag2 || tag3" 表达式过滤
        consumer.subscribe("TopicTest1", "*");
        consumer.registerMessageListener(new MessageListenerConcurrently() {

            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                log.info("{}接收到消息，msg：{}", Thread.currentThread().getName(), msgs);
                for (MessageExt messageExt : msgs){
                    String body = messageExt.getBody().toString();
                    String msgId = messageExt.getMsgId();
                    log.info("接收到消息,msgId:{},body:{}", msgId, body);
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();

        log.info("消费者启动成功");
    }
}
