package lld.visitor_design_pattern;

public class ReserveRoomVisitor implements RoomVisitor {
    @Override
    public void visit(SingleRoom room) {
        System.out.println("Reserve Single Room");
    }

    @Override
    public void visit(DoubleRoom room) {
        System.out.println("Reserve Double Room");
    }

    @Override
    public void visit(DeluxeRoom room) {
        System.out.println("Reserve Deluxe Room");
    }
}
