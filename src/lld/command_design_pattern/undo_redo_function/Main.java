package lld.command_design_pattern.undo_redo_function;

import lld.command_design_pattern.AirCondition;

public class Main {
    public static void main(String[] args) {
        // AC object
        AirCondition ac = new AirCondition();

        // remote
        MyRemoteControl remote = new MyRemoteControl();

        // create command
        TurnAcOnCommand onCommand = new TurnAcOnCommand(ac);
        TurnACOffCommand offCommand = new TurnACOffCommand(ac);

        // set command and press button
        remote.setCommand(onCommand);
        remote.pressButton(); // remote has single button to press

        // undo last operation
        remote.undo();
        remote.redo();

//        remote.setCommand(offCommand);
//        remote.pressButton();
    }
}
