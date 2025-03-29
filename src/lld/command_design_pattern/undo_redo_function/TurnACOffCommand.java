package lld.command_design_pattern.undo_redo_function;

import lld.command_design_pattern.AirCondition;

public class TurnACOffCommand implements ICommand {

    AirCondition ac;

    public TurnACOffCommand(AirCondition ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.turnOffAc();
    }

    @Override
    public void undo() {
        ac.turnOnAc();
    }
}
