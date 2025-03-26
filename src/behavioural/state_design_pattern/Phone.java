package behavioural.state_design_pattern;

public class Phone {
    private State state;

    public Phone() {
        state = new OffState(this);
    }

    public void setState(State state) {
        this.state = state;
    }

    public String lock() {
        return "Locking phone and turning off the screen";
    }

    public String home() {
        return "Going to home-screen";
    }
    public String unlock() {
        return "Unlocking phone and turning on the screen";
    }

    public String turnOn() {
        return "Turning screen on, device still locked.";
    }

    public State getState() {
        return state;
    }
}
