package lld.design_snake_ladder;

public class Jump {
    int start;
    int end;

    public Jump(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Jump{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
