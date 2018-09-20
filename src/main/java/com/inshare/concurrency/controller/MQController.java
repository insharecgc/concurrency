package com.inshare.concurrency.controller;

import com.inshare.concurrency.example.mp.kafka.KafkaSender;
import com.inshare.concurrency.example.mp.rabbitmq.RabbitMQClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Guichao
 * @since 2018/9/20
 */
@RestController
@RequestMapping("/mp")
public class MQController {

    @Autowired
    private KafkaSender kafkaSender;

    @Autowired
    private RabbitMQClient rabbitMQClient;

    @PostMapping("/send")
    public String send(String msg) {
        kafkaSender.send(msg);
        rabbitMQClient.send(msg);
        return "success send";
    }

    @PostMapping("/senddelay")
    public String senddelay(String msg) {
        rabbitMQClient.sendDelay(msg, 5000);
        return "send delay success";
    }
}
