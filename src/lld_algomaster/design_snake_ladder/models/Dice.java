package lld_algomaster.design_snake_ladder.models;

public class Dice {
    private final int min;

    private final int max;

    public Dice(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int roll() {
        return (int) (Math.random() * (max - min + 1) + min);
    }

}
