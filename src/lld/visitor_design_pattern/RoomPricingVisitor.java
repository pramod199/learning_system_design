package lld.visitor_design_pattern;

public class RoomPricingVisitor implements RoomVisitor {
    @Override
    public void visit(SingleRoom room) {
        System.out.println("Pricing for Single Room");
        room.roomPrice = 100;
    }

    @Override
    public void visit(DoubleRoom room) {
        System.out.println("Pricing for Double Room");
        room.roomPrice = 200;
    }

    @Override
    public void visit(DeluxeRoom room) {
        System.out.println("Pricing for Deluxe Room");
        room.roomPrice = 300;
    }
}
