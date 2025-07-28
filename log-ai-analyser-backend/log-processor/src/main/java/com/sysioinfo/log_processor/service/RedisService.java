package com.sysioinfo.log_processor.service;

// RedisService.java

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sysioinfo.log_processor.model.LogMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private ObjectMapper mapper;

    public void saveLog(LogMessage log) throws Exception {
        String json = mapper.writeValueAsString(log);
        redisTemplate.opsForList().leftPush("log:latest", json);
        redisTemplate.opsForList().trim("log:latest", 0, 99);
        redisTemplate.opsForHash().increment("log:levels", log.getLevel(), 1);
    }

    public void pushAlert(LogMessage log) throws Exception {
        String json = mapper.writeValueAsString(log);
        redisTemplate.opsForList().leftPush("log:alerts", json);
        redisTemplate.opsForList().trim("log:alerts", 0, 49);
    }
}