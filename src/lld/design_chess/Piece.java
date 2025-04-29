package lld.design_chess;

public abstract class Piece {
    PieceColor color;

    public Piece(PieceColor color) {
        this.color = color;
    }

    public abstract boolean isMoveValid(Cell start, Cell end);
}
