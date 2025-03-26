package lld.chain_of_responsibility_design_pattern;

public class ErrorLogProcessor extends LogProcessor {

    public ErrorLogProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void processLog(int loglevel, String message) {
        if (loglevel == ERROR) {
            System.out.println("ERROR: " + message);
        } else {
            super.processLog(loglevel, message);
        }
    }
}
