package com.lc.clz.controller;

import com.lc.clz.service.SendMesageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenglezheng
 * @date 2019-11-26 10:26
 */
@RestController
public class SendMessageController {

    @Autowired
    private SendMesageService sendMesageService;

    /**
     * 发送简单消息
     * @param topic
     * @param message
     */
    @GetMapping("sendSimpleMessage")
    public void sendSimpleMessage(String topic,String message) {
        sendMesageService.sendSimpleMessage(topic,message);
    }

}
