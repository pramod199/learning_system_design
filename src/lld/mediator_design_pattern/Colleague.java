package lld.mediator_design_pattern;

public interface Colleague {
    void placeBid(int bidAmount);
    void receiveBidNotification(int bidAmount, String bidderName);

    String getName();

}
