package lld.design_elevator;

public class ElevatorCar {
    int id;
    ElevatorDisplay display;
    InternalButtons  internalButtons;
    ElevatorState elevatorState;
    int currentFloor;
    Direction direction;
    ElevatorDoor elevatorDoor;

    public ElevatorCar(int id) {
        this.id = id;
        this.display = new ElevatorDisplay();
        this.internalButtons = new InternalButtons();
        this.elevatorState = ElevatorState.STOPPED;
        this.currentFloor = 0;
        this.direction = Direction.UP;
        this.elevatorDoor = new ElevatorDoor();
    }

    public void showDisplay(){
        display.showDisplay();
    }

    public void pressButton(int destination){
        internalButtons.pressButton(destination, this);
    }

    public void setDisplay(){
        this.display.setDisplay(this.currentFloor, this.direction);
    }

    public boolean move(Direction direction, int destinationFloor){
        int startFloor = currentFloor;
        if(direction == Direction.UP){
            this.direction = Direction.UP;
            for(int i = startFloor; i<= destinationFloor; i++){

                currentFloor = i;
                setDisplay();
                showDisplay();
                if (i == destinationFloor) {
                    return true;
                }

            }
        } else {
            this.direction = Direction.DOWN;
            for (int i = startFloor; i >= destinationFloor; i--) {

                currentFloor = i;
                setDisplay();
                showDisplay();
                if (i == destinationFloor) {
                    return true;

                }
            }
        }
        return false;
    }


}
