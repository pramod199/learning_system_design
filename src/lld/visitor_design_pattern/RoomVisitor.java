package lld.visitor_design_pattern;

/*
 Each operation is one visitor.,
 Visitor interface will have method for each concrete type element
 */
public interface RoomVisitor {
    void visit(SingleRoom room);
    void visit(DoubleRoom room);
    void visit(DeluxeRoom room);
}
