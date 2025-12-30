package lld_algomaster.logging_framework;

import lld_algomaster.logging_framework.chain_of_responsibility.DebugLogHandler;
import lld_algomaster.logging_framework.chain_of_responsibility.ErrorLogHandler;
import lld_algomaster.logging_framework.chain_of_responsibility.InfoLogHandler;
import lld_algomaster.logging_framework.chain_of_responsibility.LogHandler;
import lld_algomaster.logging_framework.enums.LogLevel;
import lld_algomaster.logging_framework.observer.ConsoleLogObserver;
import lld_algomaster.logging_framework.observer.FileLogObserver;
import lld_algomaster.logging_framework.observer.LogSinkSubject;

public class LogManager {

    public static LogHandler buildLoggerChain() {
        LogHandler infoLogger = new InfoLogHandler(LogLevel.INFO);
        LogHandler errorLogger = new ErrorLogHandler(LogLevel.ERROR);
        LogHandler debugLogger = new DebugLogHandler(LogLevel.DEBUG);

        infoLogger.setNextHandler(errorLogger);
        errorLogger.setNextHandler(debugLogger);

        return infoLogger;
    }

    public static LogSinkSubject buildLogSinkSubject() {
        LogSinkSubject logSinkSubject = new LogSinkSubject();
        logSinkSubject.addObserver(LogLevel.INFO, new ConsoleLogObserver()); // added two observer for info level
        logSinkSubject.addObserver(LogLevel.INFO, new FileLogObserver());
        logSinkSubject.addObserver(LogLevel.ERROR, new FileLogObserver());
        logSinkSubject.addObserver(LogLevel.DEBUG, new ConsoleLogObserver());

        return logSinkSubject;
    }
}