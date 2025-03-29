package lld.command_design_pattern.fix;

import lld.command_design_pattern.AirCondition;

public class TurnAcOnCommand implements ICommand {

    AirCondition ac;

    public TurnAcOnCommand(AirCondition ac) {
        this.ac = ac;
    }


    @Override
    public void execute() {
        ac.turnOnAc();
    }
}
