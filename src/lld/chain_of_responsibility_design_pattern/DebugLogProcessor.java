package lld.chain_of_responsibility_design_pattern;

public class DebugLogProcessor extends LogProcessor {

    public DebugLogProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void processLog(int loglevel, String message) {
        if (loglevel == DEBUG) {
            System.out.println("DEBUG: " + message);
        } else {
            super.processLog(loglevel, message);
        }
    }
}
