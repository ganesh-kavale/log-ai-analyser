package com.sysioinfo.log_processor.service;

import org.springframework.stereotype.Service;

@Service
public class AILogService {
    public boolean isAnomaly(String message) {
        return message.contains("Exception") || message.contains("Failed");
    }
}