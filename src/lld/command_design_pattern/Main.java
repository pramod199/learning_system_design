package lld.command_design_pattern;

public class Main {
    /*
    problem:
    1. Lack of abstraction.
    Today process of turning on ac is simple. but if there are more steps, client has to be aware all of that
    which is not good.
    2. Undo/ Redo Functionality:
    WHat if I want to implement the undo/redo capability. How it will be handled?
    3. Difficulty in code maintenance.
    what if in future we have to support more command for more devices example bulb, fan etc.
    there may be 100 object and then client need to know how to operate each.

    4. Tight coupling between the invoker and the receiver.

     */
    public static void main(String[] args) {
        AirCondition airCondition = new AirCondition();
        airCondition.turnOnAc();
        airCondition.setTemperature(20);
        airCondition.turnOffAc();

        Bulb bulb = new Bulb();
        bulb.turnOnBulb();
        bulb.turnOffBulb();
    }
}
