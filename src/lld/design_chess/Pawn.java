package lld.design_chess;

public class Pawn extends Piece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public boolean isMoveValid(Cell start, Cell end) {
        // have validation logic and if its valid return true otherwise false
        return true;
    }
}
