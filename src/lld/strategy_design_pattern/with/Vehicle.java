package lld.strategy_design_pattern.with;

import lld.strategy_design_pattern.with.strategy.DriveStrategy;

public class Vehicle {
    /*
    DriveStrategy driveStrategy = new NormalDriveStrategy();
    we are not doing this, otherwise we will not be able to change the strategy at runtime
     */
    DriveStrategy driveStrategy;

    public Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public void drive() {
        driveStrategy.drive();
    }
}
