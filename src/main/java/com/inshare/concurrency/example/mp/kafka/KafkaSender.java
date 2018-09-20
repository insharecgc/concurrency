package com.inshare.concurrency.example.mp.kafka;

import com.alibaba.fastjson.JSONObject;
import com.inshare.concurrency.example.mp.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Guichao
 * @since 2018/9/20
 */
@Component
@Slf4j
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String msg) {
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(msg);
        message.setSendTime(new Date());
        log.info("send message:{}", message);
        kafkaTemplate.send(TopicConstants.TEST, JSONObject.toJSONString(message));
    }

    public static void main(String[] args) {
        KafkaSender kafkaSender = new KafkaSender();
        kafkaSender.send("找个好工作");
    }
}
