package com.navi.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.*;

import java.io.IOException;
import java.util.Properties;

/**
 * OneProducer Class
 *
 * @author navi
 * @date 2019-04-15
 * @since 1.0.0
 */
@Slf4j
public class SomeProducer {

    private static final String TOPIC_CITIES = "cities";

    private KafkaProducer<Integer, String> producer;

    public SomeProducer() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "192.168.4.129:9092,192.168.4.129:9093,192.168.4.129:9094");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        properties.put(ProducerConfig.LINGER_MS_CONFIG, 50);

        producer = new KafkaProducer(properties);
    }

    public void sendmsg() {
        for (int i = 10000; i < 10500; i++) {
            ProducerRecord record = new ProducerRecord(TOPIC_CITIES, "cities-" + i);

            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {

                    log.info("partition:{},offset:{},topic:{}", metadata.partition(), metadata.offset(), metadata.topic());
                }

            });
        }

    }

    public static void main(String[] args) {
        SomeProducer oneProducer = new SomeProducer();
        oneProducer.sendmsg();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
