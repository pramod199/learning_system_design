package lld.strategy_design_pattern.with;

public class Main {
    public static void main(String[] args) {
        Vehicle goodsVehicle = new GoodsVehicle();
        goodsVehicle.drive();
        Vehicle sportsVehicle = new SportsVehicle();
        sportsVehicle.drive();
    }
}
