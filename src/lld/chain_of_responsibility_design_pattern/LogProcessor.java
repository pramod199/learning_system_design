package lld.chain_of_responsibility_design_pattern;

public abstract class LogProcessor {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    LogProcessor nextProcessor;

    public LogProcessor(LogProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public void processLog(int loglevel, String message) {
        if (nextProcessor != null) {
            nextProcessor.processLog(loglevel, message);
        }else {
            System.out.println("No processor found for loglevel: " + loglevel);
        }
    }

}
