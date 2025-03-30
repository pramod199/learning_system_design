package lld.mediator_design_pattern;

public interface AuctionMediator {
    void addBidder(Colleague bidder);
    void placeBid(int bidAmount, Colleague bidder);

}
