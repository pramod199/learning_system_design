package lld_algomaster.logging_framework.chain_of_responsibility;

import lld_algomaster.logging_framework.entities.LogMessage;
import lld_algomaster.logging_framework.enums.LogLevel;
import lld_algomaster.logging_framework.observer.LogSinkSubject;

public class InfoLogHandler extends  LogHandler {

    public InfoLogHandler(LogLevel level) {
        this.loglevel = level;
    }

    @Override
    public void publishLog(LogMessage message, LogSinkSubject logSinkSubject) {
        logSinkSubject.notifyObservers(this.loglevel, message);
    }
}
