package lld.mediator_design_pattern;

public class Client {
    public static void main(String[] args) {
        AuctionMediator auctionMediator =  new Auction();
        Bidder bidder1 = new Bidder("Bidder 1", auctionMediator);
        Bidder bidder2 = new Bidder("Bidder 2", auctionMediator);
        Bidder bidder3 = new Bidder("Bidder 3", auctionMediator);

        bidder1.placeBid(100);
        bidder2.placeBid(200);
        bidder1.placeBid(300);
    }
}
