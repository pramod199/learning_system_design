package lld.design_chess;

public abstract class Piece {
    String color;

    public Piece(String color) {
        this.color = color;
    }

    public abstract boolean isMoveValid(Cell start, Cell end);
}
