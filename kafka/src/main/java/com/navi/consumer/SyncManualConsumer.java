package com.navi.consumer;

import kafka.utils.ShutdownableThread;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

/**
 * OneProducer Class
 *
 * @author navi
 * @date 2019-04-15
 * @since 1.0.0
 */
@Slf4j
public class SyncManualConsumer extends ShutdownableThread {

    private static final String TOPIC_CITIES = "cities";

    private KafkaConsumer<Integer, String> consumer;

    public SyncManualConsumer() {

        super("kafkaconsumerdemo", false);

        Properties properties = new Properties();
        properties.put("bootstrap.servers", "192.168.4.129:9092,192.168.4.129:9093,192.168.4.129:9094");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.IntegerDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "cityconsumergroup");
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        // properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        properties.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "10");
        properties.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
        properties.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, "3000");
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        consumer = new KafkaConsumer(properties);
    }


    public static void main(String[] args) {
        SyncManualConsumer sc = new SyncManualConsumer();

        sc.start();

    }

    @Override
    public void doWork() {
        consumer.subscribe(Collections.singletonList(TOPIC_CITIES));

        ConsumerRecords<Integer, String> records = consumer.poll(1000);

        for (ConsumerRecord record:records){
            log.info("partition:{},offset:{},topic:{}", record.partition(), record.offset(), record.topic());
            log.info("value:{}", record.value());

            consumer.commitAsync((offset, ex)->{
                if(ex != null) {
                    log.info("offset:{}", offset);
                    log.error("异步手动提交异常", ex);
                }

            });
        }
    }
}
