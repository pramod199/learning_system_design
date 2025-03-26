package lld.design_elevator;

public class Floor {

    int floorNumber;
    ExternalDispatcher externalDispatcher;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.externalDispatcher = new ExternalDispatcher();
    }

    public void requestElevator(Direction direction) {
        externalDispatcher.submitExternalRequest(floorNumber, direction);
    }

}
