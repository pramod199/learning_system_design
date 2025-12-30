package lld_algomaster.logging_framework.strategies;

import lld_algomaster.logging_framework.entities.LogMessage;

public interface LogFormatter {
    String format(LogMessage logMessage);
}
