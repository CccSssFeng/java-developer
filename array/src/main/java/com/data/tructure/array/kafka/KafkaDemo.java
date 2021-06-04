package com.data.tructure.array.kafka;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class KafkaDemo {
    // https://blog.csdn.net/feiqinbushizheng/article/details/89184144

    public static final String MQ_ADDRESS_COLLECTION = "127.0.0.1:9092";            //kafka地址
    public static final String CONSUMER_TOPIC = "test";                        //消费者连接的topic
    public static final String PRODUCER_TOPIC = "test";                        //生产者连接的topic
    public static final String CONSUMER_GROUP_ID = "1";                                //groupId，可以分开配置
    public static final String CONSUMER_ENABLE_AUTO_COMMIT = "true";                //是否自动提交（消费者）
    public static final String CONSUMER_AUTO_COMMIT_INTERVAL_MS = "1000";
    public static final String CONSUMER_SESSION_TIMEOUT_MS = "30000";                //连接超时时间
    public static final int CONSUMER_MAX_POLL_RECORDS = 10;                            //每次拉取数
    public static final Duration CONSUMER_POLL_TIME_OUT = Duration.ofMillis(3000);    //拉去数据超时时间
    public static String partition = "0";

    static class Producer {
        private static KafkaProducer<String, String> producer = null;

        /*
        初始化生产者
         */
        static {
            Properties configs = initConfig();
            producer = new KafkaProducer<String, String>(configs);
        }

        /*
        初始化配置
         */
        private static Properties initConfig() {
            Properties props = new Properties();
            props.put("bootstrap.servers", MQ_ADDRESS_COLLECTION);
            props.put("acks", "all");
            props.put("retries", 0);
            props.put("batch.size", 16384);
            props.put("key.serializer", StringSerializer.class.getName());
            props.put("value.serializer", StringSerializer.class.getName());
            return props;
        }

        public static void main(String[] args) throws InterruptedException {
            //消息实体
            ProducerRecord<String, String> record = null;
            while (true) {
                TimeUnit.SECONDS.sleep(2);
                record = new ProducerRecord<String, String>(PRODUCER_TOPIC,
                        "hello send msg: " + new Random().nextInt(100));
                //发送消息
                producer.send(record, new Callback() {
                    @Override
                    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                        if (null != e) {
                            System.out.println("send error" + e.getMessage());
                        } else {
                            System.out.println(String.format("offset:%s,partition:%s", recordMetadata.offset(),
                                    recordMetadata.partition()));
                        }
                    }
                });
            }
            //            producer.close();
        }
    }

}
