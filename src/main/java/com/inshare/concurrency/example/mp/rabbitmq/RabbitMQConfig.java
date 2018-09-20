package com.inshare.concurrency.example.mp.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Guichao
 * @since 2018/9/20
 */
@Configuration
public class RabbitMQConfig {

    // 延迟消息
    @Bean
    public CustomExchange delayExchange() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(ExchangeConstants.TEST, "x-delayed-message",true, false, args);
    }

    @Bean
    public Queue queue() {
        Queue queue = new Queue(QueueConstants.TEST, true);
        return queue;
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(delayExchange()).with(QueueConstants.TEST).noargs();
    }

}
