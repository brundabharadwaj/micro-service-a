package com.assignment.messaging.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageBConsumer {
    public void consumeMessage(String messageBody) {
       System.out.println("Mesg"+messageBody);
    }
}
