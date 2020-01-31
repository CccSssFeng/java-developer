package com.data.tructure.array.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;

public class KafkaConsumerDemo {

    private static KafkaConsumer<String, String> consumer;


    /**
     * 初始化配置
     */
    private static Properties initConfig() {
        Properties props = new Properties();
        props.put("bootstrap.servers", KafkaDemo.MQ_ADDRESS_COLLECTION);
        props.put("group.id", KafkaDemo.CONSUMER_GROUP_ID);
        props.put("enable.auto.commit", KafkaDemo.CONSUMER_ENABLE_AUTO_COMMIT);
        props.put("auto.commit.interval.ms", KafkaDemo.CONSUMER_AUTO_COMMIT_INTERVAL_MS);
        props.put("session.timeout.ms", KafkaDemo.CONSUMER_SESSION_TIMEOUT_MS);
        props.put("max.poll.records", KafkaDemo.CONSUMER_MAX_POLL_RECORDS);
        props.put("auto.offset.reset", "earliest");
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", StringDeserializer.class.getName());
        return props;
    }

    public static void main(String[] args) {
        Properties configs = initConfig();
        consumer = new KafkaConsumer<>(configs);
        consumer.subscribe(Collections.singleton(KafkaDemo.CONSUMER_TOPIC));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(KafkaDemo.CONSUMER_POLL_TIME_OUT);
            records.forEach((ConsumerRecord<String, String> record) -> {
                System.out.println("consumer: key ===" + record.key() + " topic :【" + record.topic() + "】 value: " + record.value());
            });
        }
    }
}
