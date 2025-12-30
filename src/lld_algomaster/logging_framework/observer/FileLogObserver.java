package lld_algomaster.logging_framework.observer;

import lld_algomaster.logging_framework.entities.LogMessage;
import lld_algomaster.logging_framework.strategies.LogFormatter;
import lld_algomaster.logging_framework.strategies.SimpleTextFormatter;

public class FileLogObserver implements LogObserver {

    private LogFormatter formatter;

    public FileLogObserver() {
        this.formatter = new SimpleTextFormatter();
    }

    @Override
    public void log(LogMessage message) {
        System.out.println("file logging:" + formatter.format(message));
    }

}
