package com.veoow.storage.controllers;

import com.veoow.storage.services.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import constants.RabbitMQConstants;
import dto.PriceDTO;

@RestController
@RequestMapping("/price")
public class PriceController {
    @Autowired
    private RabbitMQService rabbitMQService;

    @PutMapping
    private ResponseEntity updatePrice(@RequestBody PriceDTO priceDTO) {
        this.rabbitMQService.sendMsg(RabbitMQConstants.QUEUE_PRICE, priceDTO);
        return new ResponseEntity(HttpStatus.OK);
    }
}
