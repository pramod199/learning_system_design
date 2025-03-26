package lld.design_elevator;

import java.util.List;
import java.util.PriorityQueue;

public class ElevatorController {

    ElevatorCar elevatorCar;

    PriorityQueue<Integer> upMinQueue;
    PriorityQueue<Integer> downMaxQueue;
    List<Integer> pendingJob; // always usd for same direction

    public ElevatorController(ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
        this.upMinQueue = new PriorityQueue<>();
        this.downMaxQueue = new PriorityQueue<>((a, b) -> b - a);
    }

    public void submitExternalRequest(int floor, Direction direction) {
        if (direction == Direction.UP) {
            upMinQueue.offer(floor);
        } else {
            downMaxQueue.offer(floor);
        }
    }

    public void submitInternalRequest(int floor) {
        if (elevatorCar.direction == Direction.UP) {
            if (floor <= elevatorCar.currentFloor) {
                pendingJob.add(floor);
            } else {
                upMinQueue.offer(floor);
            }
        } else {
            if (floor >= elevatorCar.currentFloor) {
                pendingJob.add(floor);
            } else {
                downMaxQueue.offer(floor);
            }
        }
    }

    public void controlElevator(){
        while (true) {

        }
    }
}
