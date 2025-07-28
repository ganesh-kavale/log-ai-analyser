package com.sysioinfo.log_producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public List<String> getLatestLogs() {
        return redisTemplate.opsForList().range("log:latest", 0, 49);
    }

    public List<String> getLatestAlerts() {
        return redisTemplate.opsForList().range("log:alerts", 0, 49);
    }
}
