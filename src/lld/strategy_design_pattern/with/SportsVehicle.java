package lld.strategy_design_pattern.with;

import lld.strategy_design_pattern.with.strategy.SportsDriveStrategy;

public class SportsVehicle extends Vehicle {

    public SportsVehicle() {
        super(new SportsDriveStrategy());
    }
}
