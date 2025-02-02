package com.assignment.messaging.config;

import com.assignment.messaging.service.MessageBConsumer;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerConfiguration {
        public static final String QUEUE_NAME = "queueB";

        @Bean
        SimpleMessageListenerContainer simpleMessageListenerContainer(ConnectionFactory connectionFactory, MessageListenerAdapter messageListenerAdapter) {
            SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
            simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
            simpleMessageListenerContainer.setQueueNames(QUEUE_NAME);
            simpleMessageListenerContainer.setMessageListener(messageListenerAdapter);
            return simpleMessageListenerContainer;
        }

        @Bean
        MessageListenerAdapter messageListenerAdapter(MessageBConsumer consumeMessageService) {
            return new MessageListenerAdapter(consumeMessageService, "consumeMessage");
        }



}
