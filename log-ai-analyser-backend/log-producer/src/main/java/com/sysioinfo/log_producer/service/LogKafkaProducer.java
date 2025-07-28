package com.sysioinfo.log_producer.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sysioinfo.log_producer.model.LogMessage;

@Service
public class LogKafkaProducer {
    private static final String TOPIC = "log-messages";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void sendLog(LogMessage log) {
        try {
            String msg = objectMapper.writeValueAsString(log);
            kafkaTemplate.send(TOPIC, log.getService(), msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}