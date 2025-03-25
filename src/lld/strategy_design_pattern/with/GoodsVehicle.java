package lld.strategy_design_pattern.with;

import lld.strategy_design_pattern.with.strategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle {
    public GoodsVehicle() {
        super(new NormalDriveStrategy());
    }
}
