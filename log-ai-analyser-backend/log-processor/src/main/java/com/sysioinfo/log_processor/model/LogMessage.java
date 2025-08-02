package com.sysioinfo.log_processor.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogMessage {
    private String level;
    private String service;
    private String message;
    private Instant timestamp;
    private String solution;
}
