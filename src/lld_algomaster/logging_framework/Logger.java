package lld_algomaster.logging_framework;

import lld_algomaster.logging_framework.chain_of_responsibility.LogHandler;
import lld_algomaster.logging_framework.enums.LogLevel;
import lld_algomaster.logging_framework.observer.LogSinkSubject;


public class Logger {
    private static Logger loggerInstance;

    private final static LogHandler logHandler = LogManager.buildLoggerChain();

    private final static LogSinkSubject logSinkSubject = LogManager.buildLogSinkSubject();

    private Logger() {
    }

    public static synchronized Logger getLoggerInstance() {
        if (loggerInstance == null){
            loggerInstance = new Logger();
        }
        return loggerInstance;
    }

    public void info(String message) {
        logMessage(message, LogLevel.INFO);
    }

    public void error(String message) {
        logMessage(message, LogLevel.ERROR);
    }

    public void debug(String message) {
        logMessage(message, LogLevel.DEBUG);
    }

    private void logMessage(String message, LogLevel level) {
        logHandler.log(level, message, logSinkSubject);
    }



}
