package lld.visitor_design_pattern;

public class Client {
    public static void main(String[] args) {
        RoomElement singleRoom = new SingleRoom();
        RoomElement doubleRoom = new DoubleRoom();
        RoomElement deluxeRoom = new DeluxeRoom();

        // perform an operation on the object
        RoomPricingVisitor roomPricingVisitor = new RoomPricingVisitor();
        /*
         accept is called on RoomElement interface. it decide which method to call based on the object so its single dispatch.
         argument is of type RoomVisitor interface. there it decide to call which visitor method should be called. so its double dispatch.
         */

        singleRoom.accept(roomPricingVisitor);
        System.out.println(((SingleRoom)singleRoom).roomPrice);

        doubleRoom.accept(roomPricingVisitor);
        System.out.println(((DoubleRoom)doubleRoom).roomPrice);

        // perform another operation on the object
        RoomMaintenanceVisitor roomMaintenanceVisitor = new RoomMaintenanceVisitor();
        singleRoom.accept(roomMaintenanceVisitor);
        doubleRoom.accept(roomMaintenanceVisitor);
        deluxeRoom.accept(roomMaintenanceVisitor);
    }
}
