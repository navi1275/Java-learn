package com.navi.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.IOException;
import java.util.Properties;

/**
 * OneProducer Class
 *
 * @author navi
 * @date 2019-04-15
 * @since 1.0.0
 */
public class OneProducer {

    private static final String TOPIC_CITIES = "cities";

    private KafkaProducer<Integer, String> producer;

    public OneProducer() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "192.168.4.129:9092,192.168.4.129:9093,192.168.4.129:9094");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        producer = new KafkaProducer(properties);
    }

    public void sendmsg(){
        ProducerRecord record = new ProducerRecord(TOPIC_CITIES, "changsha1");

        ProducerRecord record1 = new ProducerRecord(TOPIC_CITIES, 1,"changsha2");
        ProducerRecord record2 = new ProducerRecord(TOPIC_CITIES, 0, 1,"changsha3");

        producer.send(record);
        producer.send(record1);
        producer.send(record2);
    }

    public static void main(String[] args) {
        OneProducer oneProducer = new OneProducer();
        oneProducer.sendmsg();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
