package com.navi.springbootkafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * SomeConsumer Class
 *
 * @author navi
 * @date 2019-04-16
 * @since 1.0.0
 */

@Component
public class SomeConsumer {

    @KafkaListener(topics = "${kafka.topic}")
    public void onmsg(String msg){
        System.out.println("接收到kafka的消息：" + msg);

    }
}
