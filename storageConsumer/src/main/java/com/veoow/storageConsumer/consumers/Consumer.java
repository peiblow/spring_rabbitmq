package com.veoow.storageConsumer.consumers;

import constants.RabbitMQConstants;
import dto.StorageDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @RabbitListener(queues = RabbitMQConstants.QUEUE_STORAGE)
    private void consumer (StorageDTO storageDTO) {
        System.out.println(storageDTO.codProduct());
        System.out.println(storageDTO.quantity());
        System.out.println("_____________________________");
    }
}
