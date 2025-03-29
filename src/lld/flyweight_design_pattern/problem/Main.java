package lld.flyweight_design_pattern.problem;

public class Main {
    public static void main(String[] args) {
        int x = 0;
        int y =0;
        for(int i =0; i<500000; i++){
            Sprites humanoidSprites = new Sprites();
            Robot humanoidRobotObj = new Robot(x, y, "HUMANOID", humanoidSprites);
            // problem: for 5 lakhs object humanoid and sprites are same but has been instantiated  every time.
        }

        for(int i =0; i<500000; i++){
            Sprites dogSprites = new Sprites();
            Robot dogRobotObj = new Robot(x, y, "ROBOTIC_DOGS", dogSprites);
        }

    }
}
