package lld.mediator_design_pattern;

import java.util.ArrayList;
import java.util.List;

public class Auction implements AuctionMediator {

    List<Colleague> colleagues = new ArrayList<>();

    @Override
    public void addBidder(Colleague bidder) {
        colleagues.add(bidder);
    }

    @Override
    public void placeBid(int bidAmount, Colleague bidder) {
        for (Colleague colleague : colleagues) {
            if (colleague != bidder) {
                colleague.receiveBidNotification(bidAmount, bidder.getName());
            }
        }
    }
}
