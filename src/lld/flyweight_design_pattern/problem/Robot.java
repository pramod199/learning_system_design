package lld.flyweight_design_pattern.problem;

public class Robot {
    int coordinateX;
    int coordinateY;
    String type;
    Sprites body;

    public Robot(int coordinateX, int coordinateY, String type, Sprites body) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.type = type;
        this.body = body;
    }

    // getters and setters

}
