package lld.design_elevator;

import java.util.ArrayList;
import java.util.List;

public class ExternalDispatcher {

    List<ElevatorController> elevatorControllerList = new ArrayList<>();

    public void submitExternalRequest(int floor, Direction direction) {

        // for simplicity, I am following even odd
        ElevatorController elevatorController = elevatorControllerList.get(floor % 2);
        elevatorController.submitExternalRequest(floor, direction);
    }
}
