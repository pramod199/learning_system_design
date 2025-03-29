package lld.command_design_pattern.fix;

public class MyRemoteControl {
    ICommand command;

    public MyRemoteControl() {

    }

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

}
