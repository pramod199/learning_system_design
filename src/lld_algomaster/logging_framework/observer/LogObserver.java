package lld_algomaster.logging_framework.observer;

import lld_algomaster.logging_framework.entities.LogMessage;

public interface LogObserver {

    void log(LogMessage message);

}
