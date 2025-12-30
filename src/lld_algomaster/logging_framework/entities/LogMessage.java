package lld_algomaster.logging_framework.entities;

import lld_algomaster.logging_framework.enums.LogLevel;

import java.time.LocalDateTime;

public class LogMessage {
    private final LocalDateTime timestamp;

    private final String message;

    private final LogLevel level;

    public LogMessage(String message, LogLevel level) {
        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public LogLevel getLevel() {
        return level;
    }
}
