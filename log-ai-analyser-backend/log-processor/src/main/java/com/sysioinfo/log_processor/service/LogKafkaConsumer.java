package com.sysioinfo.log_processor.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sysioinfo.log_processor.model.LogMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class LogKafkaConsumer {

    @Autowired
    private RedisService redisService;

    @Autowired
    private AILogService aiLogService;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "log-messages", groupId = "log-processor")
    public void consume(String message) {
        try {
            LogMessage log = objectMapper.readValue(message, LogMessage.class);
            String aiSolution = aiLogService.isAnomaly(log.getMessage());

            if (aiSolution!=null) {
                redisService.pushAlert(log);
            }
            log.setSolution(aiSolution);
            redisService.saveLog(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}