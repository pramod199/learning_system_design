package lld.design_chess;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private boolean isGameOver;
    private Player winner;

    public Game(Player p1, Player p2) {
        this.board = new Board();
        this.player1 = p1;
        this.player2 = p2;
        this.currentPlayer = p1;
    }

    public boolean move(int startX, int startY, int endX, int endY) {
        if (isGameOver) {
            System.out.println("Game Over. Winner: " + (winner != null ? winner.name : "Draw"));
            return false;
        }

        Cell startCell = board.getCell(startX, startY);
        Cell endCell = board.getCell(endX, endY);

        if (startCell == null || startCell.getPiece() == null) {
            System.out.println("Invalid Move: No piece at start");
            return false;
        }
        if (!startCell.getPiece().color.toString().equals( currentPlayer.color.toString())) {
            System.out.println("Invalid Move: Not your piece");
            return false;
        }
        if (!startCell.getPiece().isMoveValid(startCell, endCell)) {
            System.out.println("Invalid Move: Move not allowed for this piece");
            return false;
        }

        // Check if end cell has opponent king
        if (endCell.getPiece() != null && endCell.getPiece() instanceof King) {
            isGameOver = true;
            winner = currentPlayer;
            System.out.println("Game Over! Winner: " + currentPlayer.name);
        }

        // Move
        endCell.setPiece(startCell.getPiece());
        startCell.setPiece(null);

        switchTurn();
        return true;
    }

    private void switchTurn() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public void printBoard() {
        System.out.println("Board:");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece p = board.cells[i][j].getPiece();
                if (p == null) System.out.print("-- ");
                else System.out.print(p.color.toString().charAt(0) + "P ");
            }
            System.out.println();
        }
    }
}
