package com.edu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/7 21:39
 */
@Component
@EnableBinding(Sink.class)
@Slf4j
public class ReceiveMessageListerController {
    @Value("${server.port}")
    private String serport;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        log.info("消费者1号，——------>接受的消息" + message.getPayload() + "\t" + "port: " + serport);
    }

}
