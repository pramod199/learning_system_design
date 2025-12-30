package lld_algomaster.logging_framework;

// https://medium.com/@say2ankitgupta/low-level-design-of-logging-framework-ffaae7c701ee

public class LogApplicationDemo {
    public static void main(String[] args) {
        Logger logger = Logger.getLoggerInstance();
        logger.info("This is info"); // info level gets printed twice as in LogSinkSubject it has two observer.
        logger.error("This is error");
        logger.debug("This is debug");
    }
}
