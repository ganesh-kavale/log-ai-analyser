package com.sysioinfo.log_producer.controller;

import com.sysioinfo.log_producer.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sysioinfo.log_producer.model.LogMessage;
import com.sysioinfo.log_producer.service.LogKafkaProducer;

import java.util.List;

@CrossOrigin(origins = "*",allowedHeaders = "http://localhost:3000")
@RestController
@RequestMapping("/api/logs")
public class LogController {

    @Autowired
    private LogKafkaProducer producer;

    @Autowired
    private LogService logService;

    @PostMapping
    public String submitLog(@RequestBody LogMessage log) {
        producer.sendLog(log);
        return "Log sent to Kafka";
    }

    @GetMapping("/log-ai-analyser")
    public List<String> getLatestLogs() {
        return logService.getLatestLogs();
    }

    @GetMapping("/alerts")
    public List<String> getLatestAlerts() {
        return logService.getLatestAlerts();
    }

}