package behavioural.state_design_pattern;

public class OffState extends State {

    public OffState(Phone phone) {
        super(phone);
    }

    /*
    jumping to another state
    and/or invoking one or several functionalities we implemented in phone class.
     */
    @Override
    public String onHome() {
        phone.setState(new LockedState(phone));
        return phone.turnOn();
    }

    @Override
    public String onLock() {
        phone.setState(new LockedState(phone));
        return phone.turnOn();
    }
}
