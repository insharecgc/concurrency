package com.inshare.concurrency.example.mp.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author Guichao
 * @since 2018/9/20
 */
@Component
@Slf4j
public class KafkaReceiver {

    @KafkaListener(topics = {TopicConstants.TEST})
    private void receive(ConsumerRecord<?, ?> record) {
        log.info("record:{}", record.value());
    }
}
