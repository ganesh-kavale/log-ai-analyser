package com.sysioinfo.log_processor.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class LocalAIClient {

    //OpenAI will be having same way of implementation
    @Value("${ollama.api-url:http://localhost:11434/api/generate}")
    private String ollamaApiUrl;

    private final WebClient webClient = WebClient.builder().build();

    public String analyzeMessage(String logMessage) {
        Map<String, Object> request = Map.of(
                "model", "deepseek-coder",
                "prompt", "Is this log an anomaly: " + logMessage,
                "stream", false
        );

        String result = webClient.post()
                .uri(ollamaApiUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> {
                    var choices = (java.util.List<Map<String, Object>>) response.get("choices");
                    return choices.get(0).get("text").toString();
                })
                .onErrorReturn("AI error occurred")
                .block();

        return result;
    }
}
