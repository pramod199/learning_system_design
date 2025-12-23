package lld_algomaster.design_tic_tac_toe;

import lld.tik_tak_toe.models.Pair;
import lld_algomaster.design_tic_tac_toe.enums.GameStatus;
import lld_algomaster.design_tic_tac_toe.exceptions.InvalidMoveException;
import lld_algomaster.design_tic_tac_toe.models.Player;
import lld_algomaster.design_tic_tac_toe.observer.Scoreboard;

import java.util.List;
import java.util.Scanner;

public class TicTacToeSystem {
    private static volatile TicTacToeSystem instance;

    private Game game;

    private final Scoreboard scoreboard;

    private TicTacToeSystem() {
        this.scoreboard = new Scoreboard();
    }

    public static synchronized TicTacToeSystem getInstance() {
        if (instance == null) {
            instance = new TicTacToeSystem();
        }
        return instance;
    }

    public void createGame(Player p1, Player p2){
        this.game = new Game(p1, p2);

        // Register the scoreboard as an observer for this new game
        this.game.addObserver(this.scoreboard);

        System.out.printf("Game started between %s (X) and %s (O).%n", p1.getName(), p2.getName());
    }

    public void startGame() {

        while (game.getStatus() == GameStatus.IN_PROGRESS) {
            printBoard();
            Player playerTurn = game.getCurrentPlayer();

            // read user input
            System.out.println("Player " + playerTurn.getName() + " Enter row and column");
            Scanner sc = new Scanner(System.in);
            int row = sc.nextInt();
            int col = sc.nextInt();

            // add player piece to board
            try {
                game.makeMove(row, col);
            } catch (InvalidMoveException e){
                System.out.println("Invalid move, try again");
                continue;
            }
        }

        if (game.getWinner() != null){
            System.out.println("game wins by " + game.getWinner().getName());

        }
        System.out.println("Game over tie");
    }


    public void printBoard() {
        game.getBoard().printBoard();
    }

    public void printScoreBoard() {
        scoreboard.printScores();
    }


}
