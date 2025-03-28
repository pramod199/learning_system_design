package lld.design_chess;

public class Board {
    Cell[][] cells = new Cell[8][8];
    Player player1;
    Player player2;
    String status;
    String turn;

    public void initializeBoard() {
        // initialize cells with pieces
        int k = 8;
        while (k-- > 0) {
            Piece p = new Pawn("black");
            cells[1][k] = new Cell(p, 1, k);
        }

        k = 8;
        while (k-- > 0) {
            Piece p = new Pawn("white");
            cells[6][k] = new Cell(p, 6, k);
        }
    }


}
