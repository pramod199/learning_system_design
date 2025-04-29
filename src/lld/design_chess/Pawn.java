package lld.design_chess;

public class Pawn extends Piece {

    public Pawn(PieceColor color) {
        super(color);
    }

    @Override
    public boolean isMoveValid(Cell start, Cell end) {
        if (end.getPiece() != null && end.getPiece().color == this.color) return false;

        int dir = (this.color == PieceColor.WHITE) ? -1 : 1;
        if (start.x + dir == end.x && start.y == end.y && end.getPiece() == null) {
            return true;
        }
        return false;
    }
}
