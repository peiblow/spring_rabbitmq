package com.veoow.priceConsumer.consumer;

import constants.RabbitMQConstants;
import dto.PriceDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @RabbitListener(queues = RabbitMQConstants.QUEUE_PRICE)
    private void consumer (PriceDTO priceDTO) {
        System.out.println("cod: " + priceDTO.codProduct());
        System.out.println("price: " + priceDTO.price());
        System.out.println("_____________________________");
    }
}
