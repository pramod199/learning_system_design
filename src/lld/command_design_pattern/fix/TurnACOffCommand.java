package lld.command_design_pattern.fix;

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
}
