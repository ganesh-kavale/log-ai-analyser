package com.sysioinfo.log_processor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AILogService {

    @Autowired
    private GeminiAIService geminiAIService;

    public String isAnomaly(String message) {

        String result = geminiAIService.analyzeMessage(message);
        return result;
    }

}