package lld.chain_of_responsibility_design_pattern;

public class InfoLogProcessor extends LogProcessor {

    public InfoLogProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void processLog(int loglevel, String message) {
        if (loglevel == INFO) {
            System.out.println("INFO: " + message);
        } else {
            super.processLog(loglevel, message);
        }
    }
}
