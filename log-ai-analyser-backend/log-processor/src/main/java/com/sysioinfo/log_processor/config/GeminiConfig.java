package com.sysioinfo.log_processor.config;

import com.google.genai.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeminiConfig {

    //If Bean name is not given then method name will be picked.
    @Bean(name="customNameForGeminiClient")
    public Client geminiClient(){
        return new Client();
    }
}
