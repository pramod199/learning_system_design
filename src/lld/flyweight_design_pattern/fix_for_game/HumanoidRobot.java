package lld.flyweight_design_pattern.fix_for_game;

import lld.flyweight_design_pattern.problem.Sprites;

// flyweightClass.
public class HumanoidRobot implements IRobot {
    /*
     coordinates are removed as those are extrinsic data.
     1. these fields are made immutable-> private field with only getter, no setters.
     */
    private String type;
    private Sprites body;

    public HumanoidRobot(String type, Sprites body) {
        this.type = type;
        this.body = body;
    }

    public String getType() {
        return type;
    }

    public Sprites getBody() {
        return body;
    }

    @Override
    public void display(int x, int y) {

    }
}
