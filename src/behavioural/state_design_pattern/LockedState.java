package behavioural.state_design_pattern;

public class LockedState extends State {
    public LockedState(Phone phone) {
        super(phone);
    }

    @Override
    public String onHome() {
        phone.setState(new ReadyState(phone));
        return phone.unlock();
    }

    @Override
    public String onLock() {
        phone.setState(new OffState(phone));
        return phone.lock();
    }
}
