package com.veoow.storage.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsg (String queueName, Object msg) {
        this.rabbitTemplate.convertAndSend(queueName, msg);
    }
}
