package lld.design_chess;

public class Board {
    Cell[][] cells = new Cell[8][8];

    public Board() {
        initializeBoard();
    }

    public void initializeBoard() {
        // Initialize empty cells
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cells[i][j] = new Cell(null, i, j);
            }
        }

        // Set black pawns
        for (int k = 0; k < 8; k++) {
            cells[1][k].setPiece(new Pawn(PieceColor.BLACK));
        }
        // Set white pawns
        for (int k = 0; k < 8; k++) {
            cells[6][k].setPiece(new Pawn(PieceColor.WHITE));
        }

        // Similarly you can set Rooks, Knights, Bishops, Queen, King if you want.
    }

    public Cell getCell(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) return null;
        return cells[x][y];
    }

}
