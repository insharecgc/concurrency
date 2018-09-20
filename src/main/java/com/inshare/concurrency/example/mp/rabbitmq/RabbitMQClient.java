package com.inshare.concurrency.example.mp.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Guichao
 * @since 2018/9/20
 */
@Component
@Slf4j
public class RabbitMQClient {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 实时发送消息
     * @param msg 消息内容
     */
    public void send(String msg) {
        rabbitTemplate.convertAndSend(QueueConstants.TEST, msg);
    }

    /**
     * 延迟发送消息
     * @param msg 消息内容
     * @param delay 延迟毫秒数
     */
    public void sendDelay(String msg, int delay) {
        rabbitTemplate.convertAndSend(ExchangeConstants.TEST, QueueConstants.TEST, msg,
                new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setHeader("x-delay",delay);
                return message;
            }
        });
    }
}
