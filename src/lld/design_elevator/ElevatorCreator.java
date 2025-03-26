package lld.design_elevator;

import java.util.ArrayList;
import java.util.List;

public class ElevatorCreator {
    static List<ElevatorController> elevatorControllerList = new ArrayList<>();
    static {
        ElevatorCar elevatorCar1 = new ElevatorCar(1);
        ElevatorController elevatorController1 = new ElevatorController(elevatorCar1);

        ElevatorCar elevatorCar2 = new ElevatorCar(2);
        ElevatorController elevatorController2 = new ElevatorController(elevatorCar2);

        elevatorControllerList.add(elevatorController1);
        elevatorControllerList.add(elevatorController2);
    }
}
