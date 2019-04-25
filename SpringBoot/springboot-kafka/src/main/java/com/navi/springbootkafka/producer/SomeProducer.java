package com.navi.springbootkafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SomeProducer Class
 *
 * @author navi
 * @date 2019-04-16
 * @since 1.0.0
 */
@RestController
public class SomeProducer {

    @Autowired
    private KafkaTemplate<String, String> template;

    @Value("${kafka.topic}")
    private String topic;

    @RequestMapping("/sendmsg")
    public Object sendmsg(String msg){
        template.send(topic, msg);

        return "success";
    }


}
