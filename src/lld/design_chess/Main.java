package lld.design_chess;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("Alice", PieceColor.WHITE);
        Player p2 = new Player("Bob", PieceColor.BLACK);

        Game game = new Game(p1, p2);
        game.printBoard();

        System.out.println("Making moves...");
        game.move(6, 0, 5, 0); // White pawn move
        game.printBoard();

        game.move(1, 1, 2, 1); // Black pawn move
        game.printBoard();

        // Invalid Move example
        game.move(6, 1, 5, 2); // White pawn diagonal move without capture
        game.printBoard();
    }
}
