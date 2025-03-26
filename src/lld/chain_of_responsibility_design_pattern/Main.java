package lld.chain_of_responsibility_design_pattern;

public class Main {
    public static void main(String[] args) {
        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(null));

        logProcessor.processLog(LogProcessor.ERROR, "This is an error message");
        logProcessor.processLog(LogProcessor.DEBUG, "This is a debug message");
        logProcessor.processLog(LogProcessor.INFO, "This is an info message");
    }
}
