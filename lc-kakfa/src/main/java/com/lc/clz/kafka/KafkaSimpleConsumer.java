package com.lc.clz.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

/**
 * kafka简单消费者
 * @author chenglezheng
 * @date 2019-11-26 10:05
 */
@Component
@Slf4j
public class KafkaSimpleConsumer {

    @KafkaListener(groupId = "simpleGroup",topics = "test")
    public void consumer1_1(ConsumerRecord<String,Object> record, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic, Consumer consumer){
        System.out.println("消费者收到消息："+record.value()+";topic:"+topic);
    }
}
