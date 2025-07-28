package com.sysioinfo.log_processor.model;


import java.time.Instant;

public class LogMessage {
    private String level;
    private String service;
    private String message;
    private Instant timestamp;

    // Getters and Setters
    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }

    public String getService() { return service; }
    public void setService(String service) { this.service = service; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Instant getTimestamp() { return timestamp; }
    public void setTimestamp(Instant timestamp) { this.timestamp = timestamp; }
}
