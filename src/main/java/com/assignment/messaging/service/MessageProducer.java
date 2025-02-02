package com.assignment.messaging.service;


import com.assignment.messaging.config.RabbitMqConfiguration;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    private final RabbitTemplate rabbitTemplate;

    public MessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public String produceMessage(String message) {
        rabbitTemplate.convertAndSend(RabbitMqConfiguration.EXCHANGE_NAME, "myRoutingKey.messages",
                message);
        return "Message(" + message + ")" + " has been produced.";
    }
}
