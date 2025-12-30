package lld_algomaster.logging_framework.chain_of_responsibility;

import lld_algomaster.logging_framework.entities.LogMessage;
import lld_algomaster.logging_framework.enums.LogLevel;
import lld_algomaster.logging_framework.observer.LogSinkSubject;

public abstract class LogHandler {
    private LogHandler nextHandler;
    protected LogLevel loglevel;

    public void setNextHandler(LogHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void log(LogLevel level, String message, LogSinkSubject logSinkSubject) {
        if (this.loglevel.getLevel() == level.getLevel()){
            LogMessage logMessage = new LogMessage(message, level);
            publishLog(logMessage, logSinkSubject);
        }
        if (nextHandler != null) {
            nextHandler.log(level, message, logSinkSubject);
        }
    }

    public abstract void publishLog(LogMessage message, LogSinkSubject logSinkSubject);

}
