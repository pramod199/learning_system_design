package lld.flyweight_design_pattern.fix_for_game;

public class Main {
    public static void main(String[] args) {
        IRobot humanoid1 = RobotFactory.createRobot("HUMANOID");
        humanoid1.display(1,2);

        IRobot humanoid2 = RobotFactory.createRobot("HUMANOID"); // this will not create new humanoid object. but will return old one from map.
        humanoid2.display(3,4);

        IRobot dog1 = RobotFactory.createRobot("ROBOTIC_DOGS");
        dog1.display(5,6);

        IRobot dog2 = RobotFactory.createRobot("ROBOTIC_DOGS");
        dog2.display(7,8);

    }
}
