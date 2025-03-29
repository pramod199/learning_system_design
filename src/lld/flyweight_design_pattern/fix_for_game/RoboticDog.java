package lld.flyweight_design_pattern.fix_for_game;

import lld.flyweight_design_pattern.problem.Sprites;

public class RoboticDog implements IRobot {

    private String type;
    private Sprites body;

    public RoboticDog(String type, Sprites body) {
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
        // use the humanoid sprites object.
        // and x, y coordinate to render the image.
    }
}
