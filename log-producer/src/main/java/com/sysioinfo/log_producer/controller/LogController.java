package com.sysioinfo.log_producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sysioinfo.log_producer.model.LogMessage;
import com.sysioinfo.log_producer.service.LogKafkaProducer;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    @Autowired
    private LogKafkaProducer producer;

    @PostMapping
    public String submitLog(@RequestBody LogMessage log) {
        producer.sendLog(log);
        return "Log sent to Kafka";
    }
}