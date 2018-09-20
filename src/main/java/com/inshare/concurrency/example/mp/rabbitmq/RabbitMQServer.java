package com.inshare.concurrency.example.mp.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Guichao
 * @since 2018/9/20
 */
@Component
@Slf4j
public class RabbitMQServer {

    @RabbitListener(queues = QueueConstants.TEST)
    private void receive(String msg) {
        log.info("rabbitMQ receive:{}",msg);
    }
}
