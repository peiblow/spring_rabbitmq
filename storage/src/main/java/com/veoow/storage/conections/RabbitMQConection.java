package com.veoow.storage.conections;

import constants.RabbitMQConstants;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConection {

    private static final String EXCHANGE_NAME = "amq.direct";
    private AmqpAdmin amqpAdmin;

    public  RabbitMQConection (AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    private Queue queue (String queueName) {
        return new Queue(queueName, true, false, false);
    }

    private DirectExchange directExchange () {
        return new DirectExchange(EXCHANGE_NAME);
    }

    private Binding binding (Queue queue, DirectExchange directExchange) {
       return new Binding(queue.getName(), Binding.DestinationType.QUEUE, directExchange.getName(), queue.getName(), null);
    }

    @PostConstruct
    private void createQueue () {
        Queue queueStorage = this.queue(RabbitMQConstants.QUEUE_STORAGE);
        Queue queuePrice = this.queue(RabbitMQConstants.QUEUE_PRICE);

        DirectExchange exchange = this.directExchange();

        Binding bindingStorage  = this.binding(queueStorage, exchange);
        Binding bindingPrice    = this.binding(queuePrice, exchange);

        this.amqpAdmin.declareQueue(queueStorage);
        this.amqpAdmin.declareQueue(queuePrice);

        this.amqpAdmin.declareExchange(exchange);

        this.amqpAdmin.declareBinding(bindingStorage);
        this.amqpAdmin.declareBinding(bindingPrice);
    }
}
