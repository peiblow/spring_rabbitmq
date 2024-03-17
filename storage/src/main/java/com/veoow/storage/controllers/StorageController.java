package com.veoow.storage.controllers;

import com.veoow.storage.services.RabbitMQService;
import constants.RabbitMQConstants;
import dto.StorageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("storage")
public class StorageController {

    @Autowired
    private RabbitMQService rabbitMQService;

    @PutMapping
    private ResponseEntity updateStorage(@RequestBody StorageDTO storageDTO) {
        this.rabbitMQService.sendMsg(RabbitMQConstants.QUEUE_STORAGE, storageDTO);
        return new ResponseEntity(HttpStatus.OK);
    }
}
