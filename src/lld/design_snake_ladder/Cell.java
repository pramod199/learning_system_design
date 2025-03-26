package lld.design_snake_ladder;

public class Cell {
    int number;
    Jump jump;

    public Cell(int number) {
        this.number = number;
    }

    public void setJump(Jump jump) {
        this.jump = jump;
    }

    public int getNumber() {
        return number;
    }

    public Jump getJump() {
        return jump;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "number=" + number +
                ", jump=" + jump +
                '}';
    }
}
