package behavioural.state_design_pattern;

public class ReadyState extends State {
    public ReadyState(Phone phone) {
        super(phone);
    }

    @Override
    public String onHome() {
        return phone.home();
    }

    @Override
    public String onLock() {
        phone.setState(new OffState(phone));
        return phone.lock();
    }
}
