package lld.visitor_design_pattern;

// element are object from which we have to take out the operations.
public interface RoomElement {
    void accept(RoomVisitor visitor);

}
