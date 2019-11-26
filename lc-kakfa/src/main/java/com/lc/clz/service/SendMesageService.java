package com.lc.clz.service;

import com.lc.clz.kafka.KafKaCustomrProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author chenglezheng
 * @date 2019-11-26 10:26
 */
@Service
public class SendMesageService {

    @Autowired
    private KafKaCustomrProducer kafKaCustomrProducer;

    public void sendSimpleMessage(String topic,String message) {
        kafKaCustomrProducer.sendMessage(topic, message);
    }
}
