package com.lc.clz.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.internals.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * kafka客户端生产者
 * @author chenglezheng
 * @date 2019-11-26 9:50
 */
@Component
@Slf4j
public class KafKaCustomrProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     * 发送简单消息
     * @param topic
     * @param object
     */
    public void sendMessage(String topic,Object object){

        /*
         * 这里的 ListenableFuture 类是 spring 对 java 原生 Future 的扩展增强,是一个泛型接口,用于监听异步方法的回调
         * 而对于 kafka send 方法返回值而言，这里的泛型所代表的实际类型就是 SendResult<K, V>,而这里 K,V 的泛型实际上
         * 被用于 ProducerRecord<K, V> producerRecord,即生产者发送消息的 key,value 类型
         */
        ListenableFuture<SendResult<String ,Object>> future=kafkaTemplate.send(topic,object);

        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.info("发送消息失败："+throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                log.info("发送消息成功："+stringObjectSendResult.toString());
            }
        });
    }


    /**
     * 测试发送消费组消息，指定分区
     */
    public void sendGroup() {
        for (int i = 0; i < 4; i++) {
            // 第二个参数指定分区，第三个参数指定消息键 分区优先
            ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(Topic.GROUP_METADATA_TOPIC_NAME, i % 4, "key", "hello group " + i);
            future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
                @Override
                public void onFailure(Throwable throwable) {
                    log.info("发送消息失败:" + throwable.getMessage());
                }

                @Override
                public void onSuccess(SendResult<String, Object> sendResult) {
                    System.out.println("发送结果:" + sendResult.toString());
                }
            });
        }
    }


}
