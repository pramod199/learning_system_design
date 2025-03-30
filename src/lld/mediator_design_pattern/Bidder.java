package lld.mediator_design_pattern;

public class Bidder implements Colleague {
    String name;
    AuctionMediator auctionMediator;

    public Bidder(String name, AuctionMediator auctionMediator) {
        this.name = name;
        this.auctionMediator = auctionMediator;
        auctionMediator.addBidder(this);
    }

    @Override
    public void placeBid(int bidAmount) {
        auctionMediator.placeBid(bidAmount, this);
    }

    @Override
    public void receiveBidNotification(int bidAmount, String bidderName) {
        System.out.println("Bidder: " + name + " received bid notification: that "+ bidderName +" has put bid of : " + bidAmount);
    }

    @Override
    public String getName() {
        return name;
    }
}
