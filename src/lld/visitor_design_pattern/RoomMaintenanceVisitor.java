package lld.visitor_design_pattern;

public class RoomMaintenanceVisitor implements RoomVisitor {
    @Override
    public void visit(SingleRoom room) {
        System.out.println("Maintenance for Single Room");
    }

    @Override
    public void visit(DoubleRoom room) {
        System.out.println("Maintenance for Double Room");
    }

    @Override
    public void visit(DeluxeRoom room) {
        System.out.println("Maintenance for Deluxe Room");
    }
}
