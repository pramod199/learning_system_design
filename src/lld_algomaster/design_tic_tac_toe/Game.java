package lld_algomaster.design_tic_tac_toe;

import lld_algomaster.design_tic_tac_toe.enums.GameStatus;
import lld_algomaster.design_tic_tac_toe.models.Board;
import lld_algomaster.design_tic_tac_toe.models.Player;
import lld_algomaster.design_tic_tac_toe.observer.GameSubject;
import lld_algomaster.design_tic_tac_toe.state.GameState;
import lld_algomaster.design_tic_tac_toe.state.InProgressState;
import lld_algomaster.design_tic_tac_toe.strategy.ColumnWinningStrategy;
import lld_algomaster.design_tic_tac_toe.strategy.DiagonalWinningStrategy;
import lld_algomaster.design_tic_tac_toe.strategy.RowWinningStrategy;
import lld_algomaster.design_tic_tac_toe.strategy.WinningStrategy;

import java.util.List;

public class Game extends GameSubject {
    private final Board board;

    private final Player player1;

    private final Player player2;

    private Player currentPlayer;

    private Player winner;

    private GameStatus status;

    private GameState state;

    private final List<WinningStrategy> winningStrategies;


    public Game(Player player1, Player player2) {
        this.board = new Board(3);
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1; // Player 1 starts
        this.status = GameStatus.IN_PROGRESS;
        this.state = new InProgressState();
        this.winningStrategies = List.of(
                new RowWinningStrategy(),
                new ColumnWinningStrategy(),
                new DiagonalWinningStrategy()
        );
    }

    public void makeMove(int row, int col) {
        state.handleMove(this, currentPlayer, row, col);
    }

    public boolean checkWinner(Player player, int row, int col) {
        for (WinningStrategy strategy : winningStrategies) {
            if (strategy.checkWinner(board, player, row, col)) {
                return true;
            }
        }
        return false;
    }

    public void switchPlayer() {
        this.currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getWinner() {
        return winner;
    }

    public Board getBoard() {
        return board;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
        // Notify observers when the status changes to a finished state
        if (status != GameStatus.IN_PROGRESS) {
            notifyObservers(this);
        }
    }
}
