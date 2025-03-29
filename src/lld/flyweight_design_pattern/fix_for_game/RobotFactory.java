package lld.flyweight_design_pattern.fix_for_game;

import lld.flyweight_design_pattern.problem.Sprites;

import java.util.HashMap;
import java.util.Map;

public class RobotFactory {
    public static Map<String, IRobot> roboticObjectCache = new HashMap<String, IRobot>();

    public static IRobot createRobot(String robotType) {
        IRobot robotCategory = roboticObjectCache.get(robotType);
        if (robotCategory == null) {
            switch (robotType) {
                case "HUMANOID":
                    System.out.println("We do not have HUMANOID Robot. So we are creating a HUMANOID Robot now.");
                    Sprites humanoidSprites = new Sprites();
                    robotCategory = new HumanoidRobot(robotType, humanoidSprites);
                    roboticObjectCache.put(robotType, robotCategory);
                    break;
                case "ROBOTIC_DOG":
                    System.out.println("We do not have ROBOTIC_DOG Robot. So we are creating a ROBOTIC_DOG Robot now.");
                    Sprites roboticDogSprites = new Sprites();
                    robotCategory = new HumanoidRobot(robotType, roboticDogSprites);
                    roboticObjectCache.put(robotType, robotCategory);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid Robot Type");
            }
        }
        return robotCategory;
    }

}
