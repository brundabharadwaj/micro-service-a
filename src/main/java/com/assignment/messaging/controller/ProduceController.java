package com.assignment.messaging.controller;

import com.assignment.messaging.service.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduceController {

    @Autowired
    MessageProducer produceMessageService;

    @PostMapping("/produce")
    public String produceMessage(@RequestParam String message) {
        return produceMessageService.produceMessage(message);
    }
}
