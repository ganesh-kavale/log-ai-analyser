package com.sysioinfo.log_processor.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import com.sysioinfo.log_processor.config.GeminiConfig;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class GeminiAIService {

    @Autowired
    @Qualifier("customNameForGeminiClient")
    private Client geminiClient;

    public String analyzeMessage(String logMessage) {


        GenerateContentResponse response =
                geminiClient.models.generateContent(
                        "gemini-2.5-flash",
                        logMessage,
                        null);
        System.out.println(response);
        System.out.println("Exceptions Solution " + response.text());
        return response.text();
    }


}
