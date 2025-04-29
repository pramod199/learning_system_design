package lld.design_chess;

public class King extends Piece {

    public King(PieceColor color) {
        super(color);
    }

    @Override
    public boolean isMoveValid(Cell start, Cell end) {
        if (end.getPiece() != null && end.getPiece().color == this.color) return false;
        int dx = Math.abs(start.x - end.x);
        int dy = Math.abs(start.y - end.y);
        return dx <= 1 && dy <= 1;
    }
}
