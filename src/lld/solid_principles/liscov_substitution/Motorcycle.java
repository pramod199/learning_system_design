package lld.solid_principles.liscov_substitution;

public class Motorcycle implements Bike {
    boolean isEngineOn;
    int speed;

    @Override
    public void turnOnEngine() {
        // Turn on the engine
        isEngineOn = true;
    }

    @Override
    public void accelerate() {
        // increase speed
        speed += 10;
    }
}
